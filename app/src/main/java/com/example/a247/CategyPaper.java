package com.example.a247;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a247.Model.PaperRSS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategyPaper extends AppCompatActivity{
    LinearLayout btn_follow, backgroupColor;
    RecyclerView rcv_list;
    private List<PaperRSS> list;
    ImageView icon, img_category;
    TextView categoryName, tv_categoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categy_paper);
        btn_follow  = findViewById(R.id.follow_category);
        icon = findViewById(R.id.iconCheck);
        backgroupColor = findViewById(R.id.backgroupCategory);
        rcv_list = findViewById(R.id.rcv_listpaperCategory);
        img_category = findViewById(R.id.img_category);
        categoryName = findViewById(R.id.categoryName);
        tv_categoryName = findViewById(R.id.tv_categoryName);


//        Intent intent = getIntent();
//        Bundle getBundle = intent.getBundleExtra("bundle_categoryID");
//        int categoryID = getBundle.getInt("CategoryID");
////        String url = getBundle.getString("URL");
//
//
//        if (categoryID == 1){
//            backgroupColor.setBackgroundResource(R.drawable.gradient_background);
//            img_category.setImageResource(R.drawable.thethao);
//            categoryName.setText("Thể Thao");
//            tv_categoryName.setText("Thể thao hôm nay");
//        }
//        if (categoryID == 2){
//            backgroupColor.setBackgroundResource(R.drawable.gradient_background2);
//            img_category.setImageResource(R.drawable.chintri);
//            categoryName.setText("Chính Trị");
//            tv_categoryName.setText("Chính Trị hôm nay");
//        }
//        if (categoryID == 3){
//            backgroupColor.setBackgroundResource(R.drawable.gradient_background1);
//            img_category.setImageResource(R.drawable.suckhoe);
//            categoryName.setText("Sức Khỏe");
//            tv_categoryName.setText("Sức khỏe cùng Đọc Báo 247");
//        }
//        if (categoryID == 4){
//            backgroupColor.setBackgroundResource(R.drawable.gradient_background5);
//            img_category.setImageResource(R.drawable.chungkhoan);
//            categoryName.setText("Chứng Khoán");
//            tv_categoryName.setText("Thị trường chứng khoán");
//        }


    }
}