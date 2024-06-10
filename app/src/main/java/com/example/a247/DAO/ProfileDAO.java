package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a247.DATA.Database;
import com.example.a247.Model.Account;
import com.example.a247.Model.Profile;
import com.example.a247.fragment.MenuFragment;

public class ProfileDAO {
    private Database dbHelper;
    public ProfileDAO(MenuFragment context){
        dbHelper = new Database(context.getContext());
    }
    public ProfileDAO(Context context){
        dbHelper = new Database(context);
    }
    public Profile getProfileByID(String id){
        Profile profile = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_profile WHERE UserID = ?",new String[]{id});
        if(cursor.moveToFirst()){
            profile = new Profile();
            profile.setProfileID(cursor.getInt(0));
            profile.setFullname(cursor.getString(1));
            profile.setUserID(cursor.getString(2));
            profile.setPhone(cursor.getString(3));
            profile.setAddress(cursor.getString(4));
            profile.setSex(cursor.getInt(5));
            profile.setDescription(cursor.getString(6));
        }
        cursor.close();
        return profile;
    }
    public void AddProfile(Account account){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String userID = account.getUserID();
        db.execSQL("INSERT INTO tbl_profile(Fullname,UserID,Phone,Address,Sex,Description) VALUES('Defaul',?,'','',1,'')",new String[]{userID});
    }

    public void UpdateProfile(Profile profile){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String Fullname = profile.getFullname();
        String Address = profile.getAddress();
        String Phone = profile.getPhone();
        int ProfileID = profile.getProfileID();
        db.execSQL("UPDATE tbl_profile SET Fullname=?, Address=?, Phone=? WHERE ProfileID=?", new String[]{Fullname,Address,Phone,String.valueOf(ProfileID)});
    }
}
