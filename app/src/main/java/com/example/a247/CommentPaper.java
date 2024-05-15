package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class CommentPaper extends AppCompatActivity {
    RecyclerView rcv_comment;
    private CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_paper);
        rcv_comment = findViewById(R.id.rcv_commentPaper);
        adapter = new CommentAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_comment.setLayoutManager(linearLayoutManager);
        adapter.setData(getListData());
        rcv_comment.setAdapter(adapter);
    }

    private List<CommetPaper> getListData() {
        List<CommetPaper> mlist = new ArrayList<>();
        mlist.add(new CommetPaper("Vân Anh","10:27 - 27/04/2024","Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí."));
        mlist.add(new CommetPaper("Vân Anh","10:27 - 27/04/2024","Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí."));
        mlist.add(new CommetPaper("Vân Anh","10:27 - 27/04/2024","Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí."));
        mlist.add(new CommetPaper("Vân Anh","10:27 - 27/04/2024","Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí."));
        return mlist;
    }

}