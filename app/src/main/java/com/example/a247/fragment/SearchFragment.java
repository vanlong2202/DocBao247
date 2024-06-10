package com.example.a247.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DetailPaperRss;
import com.example.a247.DetailReadPaper;
import com.example.a247.ItemClickListener;
import com.example.a247.PaperRss;
import com.example.a247.R;
import com.example.a247.SearchPaperAdapter;
import com.example.a247.SearchPaperAdapter1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<PaperRss> mlist;
    private List<PaperRss> list;

    private SearchPaperAdapter1 adapter;
    private RecyclerView rcv;
    private SearchView searchView;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = view.findViewById(R.id.rcv_search);
        searchView = view.findViewById(R.id.search);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setHasFixedSize(true);
        mlist = new ArrayList<>();
        adapter = new SearchPaperAdapter1(this,mlist);
        rcv.setAdapter(adapter);

        new FetchNewsTask().execute("https://vnexpress.net/rss/the-thao.rss");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list = new ArrayList<>();
                if (query.isEmpty()){
                    mlist = list;
                }else {
                    List<PaperRss> list1 = new ArrayList<>();
                    for (PaperRss paperRss: list){
                        if(paperRss.getTitle().toLowerCase().contains(query.toLowerCase())){
                            list.add(paperRss);
                        }
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


    private class FetchNewsTask extends AsyncTask<String, Void, List<PaperRss>>
    {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected List<PaperRss> doInBackground (String...strings){
            String url = strings[0];
            List<PaperRss> itemList = new ArrayList<>();
            try {
                Document document = Jsoup.connect(url).get();
                Elements items = document.select("item");
                for (Element item : items) {
                    String title = item.select("title").first().text();
                    String description = item.select("description").first().text();
                    String descriptionText = Jsoup.parse(description).text();
                    String pubDate = item.select("pubDate").first().text();
                    DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
                    ZonedDateTime dateTime = ZonedDateTime.parse(pubDate, formatter);
                    int hour = dateTime.getHour();
                    int minute = dateTime.getMinute();
                    int day = dateTime.getDayOfMonth();
                    int month = dateTime.getMonthValue();
                    int year = dateTime.getYear();
                    String time = hour+":"+minute;
                    String date = day+"-"+month+"-"+year;
                    String link = item.select("link").first().text();
                    String imageUrl = item.select("enclosure").attr("url");
                    itemList.add(new PaperRss(title, descriptionText, time,date,link,imageUrl));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return itemList;
        }

        @Override
        protected void onPostExecute (List <PaperRss> itemList) {
            super.onPostExecute(itemList);
            mlist.clear();
            mlist.addAll(itemList);
            adapter.notifyDataSetChanged();
        }
    }
}