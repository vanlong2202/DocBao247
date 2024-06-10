package com.example.a247;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.ProfileDAO;
import com.example.a247.Model.Profile;

public class ProfileUser extends AppCompatActivity {
    private EditText fullname, sex, addresss, phone;
    private LinearLayout btn_editProfile;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        back = findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fullname = findViewById(R.id.edt_fullname);
        addresss = findViewById(R.id.edt_address);
        phone = findViewById(R.id.edt_phone);
        btn_editProfile = findViewById(R.id.SaveEdit);

        AccountManeger accountManeger = new AccountManeger(ProfileUser.this);
        String email = accountManeger.getUsername();
        int ProfileID = accountManeger.getProfileID();
        Profile profile = new Profile();
        ProfileDAO profileDAO = new ProfileDAO(ProfileUser.this);
        profile = profileDAO.getProfileByID(email);

        fullname.setText(profile.getFullname());
        addresss.setText(profile.getAddress());
        phone.setText(profile.getPhone());

        btn_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fullname = fullname.getText().toString();
                String Address = addresss.getText().toString();
                String Phone = phone.getText().toString();
                Profile profile1 = new Profile();
                profile1.setProfileID(ProfileID);
                profile1.setFullname(Fullname);
                profile1.setAddress(Address);
                profile1.setPhone(Phone);
                profileDAO.UpdateProfile(profile1);
                Intent intent = new Intent(ProfileUser.this,DetailProfile.class);
                startActivity(intent);
            }
        });

    }
}