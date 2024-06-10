package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a247.DATA.Database;
import com.example.a247.Model.CategoryFL;
import com.example.a247.Model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CategoryFLDAO {
    private Database dbHelper;

    public CategoryFLDAO(Context context){
        dbHelper =new Database(context);
    }

    public boolean checkFl(int ProfileID, int CategoryID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_categoryFL WHERE ProfileID = ? AND CategoryID = ?",new String[]{String.valueOf(ProfileID),String.valueOf(CategoryID)});
        if (cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }

    public void AddCategoryFL(CategoryFL categoryFL){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int CategoryID = categoryFL.getCategoryID();
        int ProfileID = categoryFL.getProfileID();
        db.execSQL("INSERT INTO tbl_categoryFL(CategoryID,ProfileID) VALUES(?,?)",new String[]{String.valueOf(CategoryID),String.valueOf(ProfileID)});
    }
    public void DeteleCategoryFL(CategoryFL categoryFL){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int CategoryID = categoryFL.getCategoryID();
        db.execSQL("DELETE FROM tbl_categoryFL WHERE CategoryID=?", new String[]{String.valueOf(CategoryID)});
    }

    public List<CategoryFL> getAllbyProfileID(int id){
        List<CategoryFL> mlist = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ct.CategoryFLID, ct.CategoryID, ct.ProfileID, ctFl.Category_name, ctFl.Link FROM tbl_categoryFL as ct INNER JOIN tbl_category as ctFl on ct.CategoryID = ctFl.CategoryID WHERE ProfileID=?",new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
            do {
                CategoryFL categoryFL = new CategoryFL();
                categoryFL.setCategoryFLID(cursor.getInt(0));
                categoryFL.setCategoryID(cursor.getInt(1));
                categoryFL.setProfileID(cursor.getInt(2));;
                categoryFL.setCategoryName(cursor.getString(3));
                categoryFL.setLink(cursor.getString(4));
                mlist.add(categoryFL);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }
}
