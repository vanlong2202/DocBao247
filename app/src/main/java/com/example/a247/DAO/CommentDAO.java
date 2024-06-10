package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a247.DATA.Database;
import com.example.a247.Model.Comment;
import com.example.a247.fragment.HomeFragment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private Database dbHelper;
    public CommentDAO(Context context){
        dbHelper =new Database(context);
    }
    public List<Comment> getAllByPapreID(int id){
        List<Comment> mlist = new ArrayList<>();
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT cm.*, pr.Fullname FROM tbl_comment as cm INNER JOIN tbl_profile as pr on cm.ProfileID = pr.ProfileID WHERE cm.PaperID = ?",new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
            do {
                Comment comment = new Comment();
                comment.setCommentID(cursor.getInt(0));
                comment.setPaperID(cursor.getInt(1));
                comment.setProfileID(cursor.getInt(2));;
                comment.setText_comment(cursor.getString(3));
                comment.setTime_comment(cursor.getString(4));
                comment.setDate_comment(cursor.getString(5));
                comment.setDescription(cursor.getString(6));
                comment.setFullname(cursor.getString(7));
                mlist.add(comment);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void AddComment(Comment comment){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String text = comment.getText_comment();
        int profileID = comment.getProfileID();
        int papaerID = comment.getPaperID();

        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        DateTimeFormatter formatterTIME = DateTimeFormatter.ofPattern("HH:mm");
        String time_comment = time.format(formatterTIME);

        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        DateTimeFormatter formatterDATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date_comment = date.format(formatterDATE);

        db.execSQL("INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment) VALUES(?,?,?,?,?)", new String[]{String.valueOf(papaerID),String.valueOf(profileID),text,time_comment,date_comment});
    }

    public List<Comment> getAllCommentByID(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Comment> mlist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT cm.*, pr.Fullname FROM tbl_comment as cm INNER JOIN tbl_profile as pr on cm.ProfileID = pr.ProfileID WHERE cm.ProfileID = ?",new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
            do {
                Comment comment = new Comment();
                comment.setCommentID(cursor.getInt(0));
                comment.setPaperID(cursor.getInt(1));
                comment.setProfileID(cursor.getInt(2));;
                comment.setText_comment(cursor.getString(3));
                comment.setTime_comment(cursor.getString(4));
                comment.setDate_comment(cursor.getString(5));
                comment.setDescription(cursor.getString(6));
                comment.setFullname(cursor.getString(7));
                mlist.add(comment);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }

    public void DeleteComment(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL("DELETE FROM tbl_comment WHERE CommentID = ?",new String[]{String.valueOf(id)});
    }
}
