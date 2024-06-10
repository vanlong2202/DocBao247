package com.example.a247.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.CategoryPaperRss;
import com.example.a247.CategyPaper;
import com.example.a247.DAO.PaperDAO;
import com.example.a247.DetailReadPaper;
import com.example.a247.ItemClickListener;
import com.example.a247.Model.Paper;
import com.example.a247.R;
import com.example.a247.ReadThePaperAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadThePaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadThePaperFragment extends Fragment implements ItemClickListener {
    private LinearLayout btn_category1,btn_category2,btn_category3,btn_category4;
    private ImageView img_category1,img_category2,img_category3,img_category4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rcv_paperupdate, rcv_listpaper1, rcv_listpaper2, rcv_listpaper3, rcv_listpaper4;
    private List<Paper> mlist, mlist1, mlist2;
    private ReadThePaperAdapter adapter,adapter1,adapter2;
    private TextView tv_time;

    public ReadThePaperFragment() {
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
    public static ReadThePaperFragment newInstance(String param1, String param2) {
        ReadThePaperFragment fragment = new ReadThePaperFragment();
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
        return inflater.inflate(R.layout.fragment_readthepaper, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv_paperupdate = view.findViewById(R.id.rcv_paperupdate);
        tv_time = view.findViewById(R.id.tv_time);
        Date today = new Date();
        tv_time.setText(getDayAndDate(today));
        rcv_listpaper1 = view.findViewById(R.id.rcv_paperlist1);
        rcv_listpaper2 = view.findViewById(R.id.rcv_paperlist2);
        rcv_listpaper3 = view.findViewById(R.id.rcv_paperlist3);
        rcv_listpaper4 = view.findViewById(R.id.rcv_paperlist4);

        initDATA();
        initDATA1();
        initDATA2();

        rcv_paperupdate.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_paperupdate.setHasFixedSize(true);

        rcv_listpaper1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper1.setHasFixedSize(true);

        rcv_listpaper2.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper2.setHasFixedSize(true);

        rcv_listpaper3.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper3.setHasFixedSize(true);

        rcv_listpaper4.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper4.setHasFixedSize(true);

        adapter = new ReadThePaperAdapter(this,mlist,this);
        adapter1 = new ReadThePaperAdapter(this,mlist1,this);
        adapter2 = new ReadThePaperAdapter(this,mlist2,this);
        rcv_paperupdate.setAdapter(adapter);
        rcv_listpaper1.setAdapter(adapter1);
        rcv_listpaper2.setAdapter(adapter);
        rcv_listpaper3.setAdapter(adapter2);
        rcv_listpaper4.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btn_category1 = view.findViewById(R.id.category1);
        btn_category2 = view.findViewById(R.id.category2);
        btn_category3 = view.findViewById(R.id.category3);
        btn_category4 = view.findViewById(R.id.category4);
        img_category1 = view.findViewById(R.id.img_category1);
        img_category2 = view.findViewById(R.id.img_category2);
        img_category3 = view.findViewById(R.id.img_category3);
        img_category4 = view.findViewById(R.id.img_category4);
        btn_category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 1;
                String url = "https://vnexpress.net/rss/the-thao.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        img_category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 1;
                String url = "https://vnexpress.net/rss/the-thao.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        btn_category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 2;
                String url = "https://vnexpress.net/rss/thoi-su.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        img_category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 2;
                String url = "https://vnexpress.net/rss/thoi-su.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        btn_category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 3;
                String url = "https://vnexpress.net/rss/suc-khoe.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        img_category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 3;
                String url = "https://vnexpress.net/rss/suc-khoe.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        btn_category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 4;
                String url = "https://vnexpress.net/rss/kinh-doanh.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        img_category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Category = 4;
                String url = "https://vnexpress.net/rss/kinh-doanh.rss";
                Intent intent = new Intent(getActivity(), CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
    }

    private void initDATA() {
        mlist = new ArrayList<>();
        PaperDAO dao = new PaperDAO(ReadThePaperFragment.this);
        mlist = dao.getAllOrderBy();
    }
    private void initDATA1() {
        mlist1 = new ArrayList<>();
        PaperDAO dao = new PaperDAO(ReadThePaperFragment.this);
        mlist1 = dao.getAllByCactegoryID(1);
    }
    private void initDATA2() {
        mlist2 = new ArrayList<>();
        PaperDAO dao = new PaperDAO(ReadThePaperFragment.this);
        mlist2 = dao.getAllByCactegoryID(2);
    }

    @Override
    public void OnItemClick(int positionItem) {
        int id = mlist.get(positionItem).getPaperID();
        Intent intent = new Intent(getActivity(), DetailReadPaper.class);
        intent.putExtra("PaperID",id);
        startActivity(intent);
    }
    public static String getDayAndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String[] days = {"Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy"};

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        String dayName = days[dayOfWeek - 1];

        return dayName + ", " + day +"/"+ month +"/"+ year;
    }
}