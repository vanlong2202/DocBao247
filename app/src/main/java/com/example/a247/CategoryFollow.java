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
import com.example.a247.DAO.CategoryFLDAO;
import com.example.a247.Model.CategoryFL;

import java.util.List;

public class CategoryFollow extends AppCompatActivity {
    private RecyclerView rcv;
    private List<CategoryFL> list;
    private ImageView back;
    private CategoryFollowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_follow);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcv = findViewById(R.id.rcv_categoryFL);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AccountManeger accountManeger = new AccountManeger(CategoryFollow.this);
        int ProfileID = accountManeger.getProfileID();
        CategoryFLDAO categoryFLDAO = new CategoryFLDAO(CategoryFollow.this);
        list = categoryFLDAO.getAllbyProfileID(ProfileID);
        adapter = new CategoryFollowAdapter(this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);

    }
}