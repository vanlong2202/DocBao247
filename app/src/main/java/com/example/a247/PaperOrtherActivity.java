package com.example.a247;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PaperOrtherActivity extends AppCompatActivity {
    private List<PaperRss> mlist;
    private SearchPaperAdapter adapter;
    private RecyclerView rcv;
    private TextView name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_paper_orther);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcv = findViewById(R.id.rcv);
        back = findViewById(R.id.img_back);
        name = findViewById(R.id.tv_name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        name.setText(intent.getStringExtra("NAME"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);

        mlist = new ArrayList<>();
        adapter = new SearchPaperAdapter(this,mlist);
        rcv.setAdapter(adapter);
        new FetchNewsTask().execute(url);
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