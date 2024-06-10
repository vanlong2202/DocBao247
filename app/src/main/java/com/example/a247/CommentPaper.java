package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.CommentDAO;
import com.example.a247.Model.Comment;

import java.util.List;

public class CommentPaper extends AppCompatActivity {
    RecyclerView rcv_comment;
    EditText text_comment;
    LinearLayout btn_comment;
    private List<Comment> mlist;
    private CommentAdapter adapter;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_paper);
        rcv_comment = findViewById(R.id.rcv_commentPaper);
        text_comment = findViewById(R.id.edt_comment);
        btn_comment = findViewById(R.id.btn_comment);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        Bundle getBundle = intent.getBundleExtra("bundle_paperid");
        int paperID = getBundle.getInt("PaperID");
        CommentDAO dao = new CommentDAO(CommentPaper.this);
        mlist = dao.getAllByPapreID(paperID);
        adapter = new CommentAdapter(this,mlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_comment.setLayoutManager(linearLayoutManager);
        rcv_comment.setAdapter(adapter);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountManeger accountManeger = new AccountManeger(CommentPaper.this);
                boolean checkLogin = accountManeger.isLoggedIn();
                if (checkLogin){
                    String text = text_comment.getText().toString();
                    int profileID = accountManeger.getProfileID();
                    Comment comment = new Comment();
                    comment.setText_comment(text);
                    comment.setProfileID(profileID);
                    comment.setPaperID(paperID);
                    CommentDAO commentDAO = new CommentDAO(CommentPaper.this);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        commentDAO.AddComment(comment);
                        finish();
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent1 = new Intent(CommentPaper.this, LoginActivity.class);
                    startActivity(intent1);
                }
            }
        });
    }



}