package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a247.DAO.AccountDAO;
import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.ProfileDAO;
import com.example.a247.Model.Profile;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    TextView notification, tv_nextSignup;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.loginButton);
        notification = findViewById(R.id.notification);
        tv_nextSignup = findViewById(R.id.next_Signup);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().length() != 0 && password.getText().length() != 0){
                    String tk = email.getText().toString().trim();
                    String mk = password.getText().toString().trim();
                    AccountDAO dao = new AccountDAO(LoginActivity.this);
                    boolean check = dao.CheckAccount(tk,mk);
                    if(check){
                        ProfileDAO profileDAO = new ProfileDAO(LoginActivity.this);
                        Profile profile = profileDAO.getProfileByID(tk);
                        int profileID = profile.getProfileID();
                        AccountManeger accountManeger = new AccountManeger(LoginActivity.this);
                        accountManeger.saveAccount(tk,mk,profileID);
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        notification.setText("Thông tin đăng nhập không chính xác.");
                    }
                }
                else {
                    notification.setText("Vui lòng nhập thông tin.");
                }
            }
        });
        tv_nextSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}