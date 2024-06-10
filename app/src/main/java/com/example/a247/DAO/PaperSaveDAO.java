package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a247.DATA.Database;
import com.example.a247.Model.Paper;
import com.example.a247.Model.PaperSave;
import com.example.a247.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class PaperSaveDAO {
    private Database dbHelper;
    public PaperSaveDAO(Context context){
        dbHelper =new Database(context);
    }
    public void SavePaper(int PaperID, int ProfileID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL("INSERT INTO tbl_paperSave(PaperID,ProfileID) VALUES(?,?)",new String[]{String.valueOf(PaperID),String.valueOf(ProfileID)});
    }
    public boolean CheckPaperSave(int PaperID, int ProfileID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_paperSave WHERE PaperID =? AND ProfileID =?",new String[]{String.valueOf(PaperID),String.valueOf(ProfileID)});
        if (cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }
    public void DeletePaperSave(int PaperID, int ProfileID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL("DELETE FROM tbl_paperSave WHERE PaperID =? AND ProfileID =?",new String[]{String.valueOf(PaperID),String.valueOf(ProfileID)});
    }

    public List<PaperSave> getAllByID(int ProfileID){
        List<PaperSave> mlist = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ppS.PaperSaveID, ppS.PaperID, ppS.ProfileID, pp.Title_paper, pp.Time_paper, pp.Date_paper FROM tbl_paperSave as ppS INNER JOIN tbl_paper as pp on ppS.PaperID = pp.PaperID WHERE ppS.ProfileID = ?",new String[]{String.valueOf(ProfileID)});
        if(cursor.moveToFirst()){
            do{
                PaperSave paperSave = new PaperSave();
                paperSave.setPaperSaveID(cursor.getInt(0));
                paperSave.setPaperID(cursor.getInt(1));
                paperSave.setProfileID(cursor.getInt(2));
                paperSave.setTitle(cursor.getString(3));
                paperSave.setTime(cursor.getString(4));
                paperSave.setDate(cursor.getString(5));
                mlist.add(paperSave);
            }while (cursor.moveToNext());
        }
        return mlist;

    }
}
