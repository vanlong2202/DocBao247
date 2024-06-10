package com.example.a247.DAO;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.a247.fragment.MenuFragment;

public class AccountManeger {
    private SharedPreferences sharedPreferences;

    public AccountManeger(Context context) {
        sharedPreferences = context.getSharedPreferences("Account", context.MODE_PRIVATE);
    }
    public AccountManeger(MenuFragment context) {
        sharedPreferences = context.getContext().getSharedPreferences("Account", context.getContext().MODE_PRIVATE);
    }
    public void saveAccount(String email, String password, int profileID) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putInt("profileID", profileID);
        editor.putBoolean("is_logged_in", true); // Đánh dấu người dùng đã đăng nhập
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString("email", null);
    }
    public int getProfileID() {
        return sharedPreferences.getInt("profileID", -1);
    }
    public String getPassword() {
        return sharedPreferences.getString("password", null);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean("is_logged_in", false);
    }

    public void clearAccount() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
