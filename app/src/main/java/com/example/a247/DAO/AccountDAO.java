package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a247.DATA.Database;
import com.example.a247.Model.Account;

public class AccountDAO {
    private Database dbHelper;
    public AccountDAO(Context context){
        dbHelper =new Database(context);
    }
    public boolean CheckAccount(String tk, String mk){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_account WHERE UserID = ? AND Password = ?",new String[]{tk,mk});
        if (cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean CheckEmail(String tk){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_account WHERE UserID = ?",new String[]{tk});
        if (cursor.getCount() != 0){
            return false;
        }else {
            return true;
        }
    }

    public void AddAccount(Account account){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String UserID = account.getUserID();
        String Password = account.getPassword();
        db.execSQL("INSERT INTO tbl_account(UserID,Password) VALUES(?,?)",new String[]{UserID,Password});
    }

    public void UpdatePass(Account account){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String pass = account.getPassword();
        String usedID = account.getUserID();
        db.execSQL("UPDATE tbl_account set Password=? WHERE UserID=?",new String[]{pass,usedID});
    }
}
