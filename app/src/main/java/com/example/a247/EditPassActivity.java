package com.example.a247;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a247.DAO.AccountDAO;
import com.example.a247.DAO.AccountManeger;
import com.example.a247.Model.Account;

public class EditPassActivity extends AppCompatActivity {
    LinearLayout btn_editPass;
    TextView checkPass, checkNewPass;
    EditText pass, newPass, newPassCheck;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pass = findViewById(R.id.pass);
        newPass = findViewById(R.id.newPass);
        newPassCheck = findViewById(R.id.newPassCheck);
        checkPass = findViewById(R.id.checkPass);
        checkNewPass = findViewById(R.id.notification);
        btn_editPass = findViewById(R.id.btn_EditPass);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_editPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().length()!=0 && newPass.getText().length() !=0 && newPassCheck.getText().length()!=0){
                    String text_pass = pass.getText().toString().trim();
                    String text_newPass = newPass.getText().toString().trim();
                    String text_newPassCheck = newPassCheck.getText().toString().trim();
                    AccountManeger accountManeger = new AccountManeger(EditPassActivity.this);
                    String PassWord = accountManeger.getPassword();
                    String UserID = accountManeger.getUsername();
                    int ProfiliID = accountManeger.getProfileID();
                    checkNewPass.setText("");
                    if (text_pass.equals(PassWord))
                    {
                        checkPass.setText("");
                        if(text_newPass.equals(text_newPassCheck)){

                            Account account  = new Account();
                            account.setPassword(text_newPass);
                            account.setUserID(UserID);
                            AccountDAO accountDAO = new AccountDAO(EditPassActivity.this);
                            accountDAO.UpdatePass(account);
                            accountManeger.clearAccount();
                            accountManeger.saveAccount(UserID,text_newPass,ProfiliID);
                            Intent intent = new Intent(EditPassActivity.this,MainActivity.class);
                            startActivity(intent);
                            checkNewPass.setText("");
                        } else {
                            checkNewPass.setText("Mật khẩu không trùng nhau.");
                        }

                    }
                    else {
                        checkPass.setText("Mật khẩu không chính xác.");
                    }
                }
                else {
                    checkNewPass.setText("Vui lòng nhập đầy đủ thông tin.");
                }
            }
        });
    }
}