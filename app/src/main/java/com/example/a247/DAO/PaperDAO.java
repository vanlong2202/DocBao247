package com.example.a247.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a247.DATA.Database;
import com.example.a247.Model.Comment;
import com.example.a247.Model.Paper;
import com.example.a247.fragment.HomeFragment;
import com.example.a247.fragment.ReadThePaperFragment;

import java.util.ArrayList;
import java.util.List;

public class PaperDAO {
    private Database dbHelper;
    public PaperDAO(HomeFragment context){
        dbHelper =new Database(context.getContext());
    }
    public PaperDAO(ReadThePaperFragment context){
        dbHelper =new Database(context.getContext());
    }
    public PaperDAO(Context context1){
        dbHelper =new Database(context1);
    }
    public List<Paper> getAllByCactegoryID(int id){
        List<Paper> paperList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT p.*, ct.Category_name FROM tbl_paper as p inner join tbl_category as ct on p.CategoryID = ct.CategoryID WHERE p.CategoryID = ?",new String[]{String.valueOf(id)});
        if(cursor.moveToFirst()){
            do{
                int paperID = cursor.getInt(0);
                String title_paper = cursor.getString(1);
                String text1_paper = cursor.getString(2);
                String text2_paper = cursor.getString(3);
                String img_paper = cursor.getString(4);
                String time_paper = cursor.getString(5);
                String date_paper = cursor.getString(6);
                int categoryID = cursor.getInt(7);
                String decscription = cursor.getString(8);
                String category_name = cursor.getString(9);
                Paper paper = new Paper(paperID,title_paper,text1_paper,text2_paper,img_paper,time_paper,date_paper,categoryID,decscription,category_name);
                paperList.add(paper);
            }while (cursor.moveToNext());
        }
        return paperList;
    }
    public List<Paper> getAll(){
        List<Paper> paperList = new ArrayList<>();
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT p.*, ct.Category_name FROM tbl_paper as p inner join tbl_category as ct on p.CategoryID = ct.CategoryID", null);
        if(cursor.moveToFirst()){
            do{
                int paperID = cursor.getInt(0);
                String title_paper = cursor.getString(1);
                String text1_paper = cursor.getString(2);
                String text2_paper = cursor.getString(3);
                String img_paper = cursor.getString(4);
                String time_paper = cursor.getString(5);
                String date_paper = cursor.getString(6);
                int categoryID = cursor.getInt(7);
                String decscription = cursor.getString(8);
                String category_name = cursor.getString(9);
                Paper paper = new Paper(paperID,title_paper,text1_paper,text2_paper,img_paper,time_paper,date_paper,categoryID,decscription,category_name);
                paperList.add(paper);
            }while (cursor.moveToNext());
        }
        return paperList;
    }
    public List<Paper> getAllOrderBy(){
        List<Paper> paperList = new ArrayList<>();
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT p.*, ct.Category_name FROM tbl_paper as p inner join tbl_category as ct on p.CategoryID = ct.CategoryID ORDER by p.Time_paper DESC", null);
        if(cursor.moveToFirst()){
            do{
                int paperID = cursor.getInt(0);
                String title_paper = cursor.getString(1);
                String text1_paper = cursor.getString(2);
                String text2_paper = cursor.getString(3);
                String img_paper = cursor.getString(4);
                String time_paper = cursor.getString(5);
                String date_paper = cursor.getString(6);
                int categoryID = cursor.getInt(7);
                String decscription = cursor.getString(8);
                String category_name = cursor.getString(9);
                Paper paper = new Paper(paperID,title_paper,text1_paper,text2_paper,img_paper,time_paper,date_paper,categoryID,decscription,category_name);
                paperList.add(paper);
            }while (cursor.moveToNext());
        }
        return paperList;
    }
    public Paper getPaperByID(int id){
        Paper paper = null;
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT p.*, ct.Category_name FROM tbl_paper as p inner join tbl_category as ct on p.CategoryID = ct.CategoryID where PaperID = ?",new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
            int paperID = cursor.getInt(0);
            String title_paper = cursor.getString(1);
            String text1_paper = cursor.getString(2);
            String text2_paper = cursor.getString(3);
            String img_paper = cursor.getString(4);
            String time_paper = cursor.getString(5);
            String date_paper = cursor.getString(6);
            int categoryID = cursor.getInt(7);
            String decscription = cursor.getString(8);
            String category_name = cursor.getString(9);
            paper = new Paper(paperID,title_paper,text1_paper,text2_paper,img_paper,time_paper,date_paper,categoryID,decscription,category_name);
        }
        cursor.close();
        return paper;
    }
}
