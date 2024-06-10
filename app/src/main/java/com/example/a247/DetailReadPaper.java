package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a247.DAO.PaperDAO;
import com.example.a247.Model.Paper;

public class DetailReadPaper extends AppCompatActivity {
    TextView tv_category, tv_timepaper, tv_title, tv_text1, tv_text2, tv_date;
    ImageView img_paper;
    ImageView btn_comment, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_read_paper);
        btn_comment = findViewById(R.id.btn_comment);
        tv_category = findViewById(R.id.tv_categoryName);
        tv_timepaper = findViewById(R.id.tv_timePaper);
        tv_title = findViewById(R.id.tv_titlePaper);
        tv_text1 = findViewById(R.id.tv_text1Paper);
        tv_text2 = findViewById(R.id.tv_text2Paper);
        img_paper = findViewById(R.id.imgPaper);
        tv_date = findViewById(R.id.tv_datePaper);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        int paperID = intent.getIntExtra("PaperID",-1);

        PaperDAO dao = new PaperDAO(DetailReadPaper.this);
        Paper paper = new Paper();
        paper = dao.getPaperByID(paperID);

        tv_category.setText(paper.getCategory_name());
        tv_timepaper.setText(paper.getTime_paper());
        tv_title.setText(paper.getTitle_paper());
        tv_text1.setText(paper.getText1_paper());
        tv_text2.setText(paper.getText2_paper());
        tv_date.setText(paper.getDate_paper());
        String image = paper.getImg_paper();
        int imageResource = getResources().getIdentifier(image,"drawable",getPackageName());
        img_paper.setImageResource(imageResource);
        int id = paper.getPaperID();
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailReadPaper.this, CommentPaper.class);
                Bundle myBundle = new Bundle();
                myBundle.putInt("PaperID",id);
                intent.putExtra("bundle_paperid",myBundle);
                startActivity(intent);
            }
        });
    }
}