package com.example.a247;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.CommentDAO;
import com.example.a247.Model.Comment;

import java.util.List;

public class CommentUser extends AppCompatActivity {
    private RecyclerView rcv;
    private List<Comment> mlist;
    private ListCommentAdapter adapter;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comment_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AccountManeger accountManeger = new AccountManeger(this);
        int ProfileID = accountManeger.getProfileID();
        rcv = findViewById(R.id.rcv_listComment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);
        CommentDAO dao = new CommentDAO(CommentUser.this);
        mlist = dao.getAllCommentByID(ProfileID);
        adapter = new ListCommentAdapter(mlist,this);
        rcv.setAdapter(adapter);
    }
}