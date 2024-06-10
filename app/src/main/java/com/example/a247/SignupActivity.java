package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a247.DAO.AccountDAO;
import com.example.a247.DAO.ProfileDAO;
import com.example.a247.Model.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    EditText email, password, checkpass;
    TextView notification, tv_notification1, tv_nextLogin;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.signupEmail);
        password = findViewById(R.id.signupPass);
        checkpass = findViewById(R.id.CheckPassword);
        notification = findViewById(R.id.notification);
        tv_notification1 = findViewById(R.id.notification1);
        btn_signup = findViewById(R.id.signupButton);
        tv_nextLogin = findViewById(R.id.next_Login);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().length() != 0 && password.getText().length() != 0 && checkpass.getText().length() != 0){
                    String tk = email.getText().toString().trim();
                    String mk = password.getText().toString().trim();
                    String checkmk = checkpass.getText().toString().trim();
                    AccountDAO dao = new AccountDAO(SignupActivity.this);
                    ProfileDAO dao1 = new ProfileDAO(SignupActivity.this);
                    boolean checkEmail = dao.CheckEmail(tk);
                    boolean checkType = checkTypeMail(tk);
                    if (checkType){
                        if (checkEmail){
                            if (mk.equals(checkmk)){
                                Account account = new Account();
                                account.setUserID(tk);
                                account.setPassword(mk);
                                dao.AddAccount(account);
                                dao1.AddProfile(account);
                                notification.setText("");
                                tv_notification1.setText("Đăng kí tài khoản thành công.");
                            }else {
                                notification.setText("Mật khẩu không trùng nhau.");
                            }
                        }
                        else {
                            notification.setText("Email đã được sử dụng.");
                        }
                    } else {
                        notification.setText("Email không hợp lệ.");
                    }


                }
                else {
                    notification.setText("Vui lòng nhập đầy đủ thông tin.");
                }
            }
        });
        tv_nextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public static boolean checkTypeMail(String email){
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_.-]+)@gmail\\.com$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}