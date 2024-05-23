package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a247.Adapter.CommentAdapter;
import com.example.a247.Model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentPaper extends AppCompatActivity {
    RecyclerView rcv_comment;
    private List<Comment> mlist;
    private CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_paper);
        rcv_comment = findViewById(R.id.rcv_commentPaper);
        initData();
        adapter = new CommentAdapter(this,mlist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_comment.setLayoutManager(linearLayoutManager);
        rcv_comment.setAdapter(adapter);
    }

    private void initData() {
        mlist = new ArrayList<>();
        mlist.add(new Comment(1,1,1,"Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí.","10:27 - 27/04/2024","27/04/2024",""));
        mlist.add(new Comment(1,1,1,"Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí.","10:27 - 27/04/2024","27/04/2024",""));
        mlist.add(new Comment(1,1,1,"Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí.","10:27 - 27/04/2024","27/04/2024",""));
        mlist.add(new Comment(1,1,1,"Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí.","10:27 - 27/04/2024","27/04/2024",""));
        mlist.add(new Comment(1,1,1,"Kinh tế suy thoái, nhà nước đang mạnh tay thiết chặt các quản lí.","10:27 - 27/04/2024","27/04/2024",""));
    }

}