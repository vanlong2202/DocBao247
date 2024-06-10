package com.example.a247;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.CategoryFLDAO;
import com.example.a247.Model.CategoryFL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategoryPaperRss extends AppCompatActivity {
    private RecyclerView rcv_list;
    private PaperRssAdapter adapter;
    private List<PaperRss> list;
    private ImageView img_category, icon, back;
    private LinearLayout backgroupColor, follow_category;
    private TextView categoryName,tv_categoryName,tv_fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_paper_rss);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backgroupColor = findViewById(R.id.backgroupCategory);
        img_category = findViewById(R.id.img_category);
        categoryName = findViewById(R.id.categoryName);
        tv_categoryName = findViewById(R.id.tv_categoryName);
        follow_category = findViewById(R.id.follow_category);
        icon = findViewById(R.id.iconCheck);
        tv_fl = findViewById(R.id.tv_follow);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        int categoryID = intent.getIntExtra("CategoryID",-1);
        String url = intent.getStringExtra("URL");

        AccountManeger accountManeger = new AccountManeger(CategoryPaperRss.this);
        boolean checkIsLogIN = accountManeger.isLoggedIn();
        CategoryFLDAO categoryFLDAO = new CategoryFLDAO(CategoryPaperRss.this);

        if (checkIsLogIN){
            int ProfileID = accountManeger.getProfileID();
            boolean checkFl = categoryFLDAO.checkFl(ProfileID,categoryID);
            if (checkFl){
                tv_fl.setText("Đã theo dõi");
                icon.setImageResource(R.drawable.check_solid);
            }
        }
        follow_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIsLogIN){
                    int ProfileID = accountManeger.getProfileID();
                    boolean checkFl = categoryFLDAO.checkFl(ProfileID,categoryID);
                    if (checkFl){
                        CategoryFL categoryFL = new CategoryFL();
                        categoryFL.setCategoryID(categoryID);
                        categoryFL.setProfileID(ProfileID);
                        categoryFLDAO.DeteleCategoryFL(categoryFL);
                        finish();
                        startActivity(intent);
                    }
                    else {
                        CategoryFL categoryFL = new CategoryFL();
                        categoryFL.setCategoryID(categoryID);
                        categoryFL.setProfileID(ProfileID);
                        categoryFLDAO.AddCategoryFL(categoryFL);
                        finish();
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(CategoryPaperRss.this, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });


        if (categoryID == 1){
            backgroupColor.setBackgroundResource(R.drawable.gradient_background);
            img_category.setImageResource(R.drawable.thethao);
            categoryName.setText("Thể Thao");
            tv_categoryName.setText("Thể thao hôm nay");
        }
        if (categoryID == 2){
            backgroupColor.setBackgroundResource(R.drawable.gradient_background2);
            img_category.setImageResource(R.drawable.chintri);
            categoryName.setText("Chính Trị");
            tv_categoryName.setText("Chính Trị hôm nay");
        }
        if (categoryID == 3){
            backgroupColor.setBackgroundResource(R.drawable.gradient_background1);
            img_category.setImageResource(R.drawable.suckhoe);
            categoryName.setText("Sức Khỏe");
            tv_categoryName.setText("Sức khỏe cùng Đọc Báo 247");
        }
        if (categoryID == 4){
            backgroupColor.setBackgroundResource(R.drawable.gradient_background5);
            img_category.setImageResource(R.drawable.chungkhoan);
            categoryName.setText("Chứng Khoán");
            tv_categoryName.setText("Thị trường chứng khoán");
        }
        rcv_list = findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_list.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        adapter = new PaperRssAdapter(this,list);
        rcv_list.setAdapter(adapter);

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
            list.clear();
            list.addAll(itemList);
            adapter.notifyDataSetChanged();
        }
    }
}