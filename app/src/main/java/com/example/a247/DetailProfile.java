package com.example.a247;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.fragment.HomeFragment;

public class DetailProfile extends AppCompatActivity {
    LinearLayout btn_Logout, btn_editPass, btn_editProfile, btn_categoryFL, btn_papersave, btn_comment;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_Logout = findViewById(R.id.btn_logout);
        btn_editPass = findViewById(R.id.btn_editPass);
        btn_editProfile = findViewById(R.id.btn_editProfile);
        btn_categoryFL = findViewById(R.id.btn_categoryFL);
        btn_papersave = findViewById(R.id.btn_papersave);
        btn_comment = findViewById(R.id.listComment);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfile.this, CommentUser.class);
                startActivity(intent);

            }
        });
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_papersave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfile.this,PaperSaveActivity.class);
                startActivity(intent);
            }
        });
        btn_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfile.this,ProfileUser.class);
                startActivity(intent);
            }
        });
        btn_editPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfile.this,EditPassActivity.class);
                startActivity(intent);
            }
        });
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountManeger accountManeger = new AccountManeger(DetailProfile.this);
                accountManeger.clearAccount();
                Intent intent = new Intent(DetailProfile.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_categoryFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfile.this, CategoryFollow.class);
                startActivity(intent);
            }
        });
    }
}