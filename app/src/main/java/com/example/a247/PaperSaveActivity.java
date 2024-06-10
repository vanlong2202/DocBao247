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
import com.example.a247.DAO.PaperSaveDAO;
import com.example.a247.Model.PaperRSS;
import com.example.a247.Model.PaperSave;

import java.util.List;

public class PaperSaveActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private List<PaperSave> mlist;
    private PaperSaveAdapter adapter;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_paper_save);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcv = findViewById(R.id.rcv_paperSave);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AccountManeger accountManeger = new AccountManeger(PaperSaveActivity.this);
        int ProfileID = accountManeger.getProfileID();
        PaperSaveDAO paperSaveDAO = new PaperSaveDAO(PaperSaveActivity.this);
        mlist = paperSaveDAO.getAllByID(ProfileID);
        adapter = new PaperSaveAdapter(this,mlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);
    }
}