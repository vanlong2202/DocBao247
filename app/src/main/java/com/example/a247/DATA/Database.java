package com.example.a247.DATA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "docbao247";
    private static final int DATABASE_VERSION = 1;
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String CREATE_TABLE_ACCOUNT = "CREATE TABLE tbl_account (" +
            "UserID TEXT PRIMARY KEY," +
            "Password TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE tbl_profile (" +
            "ProfileID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Fullname TEXT," +
            "UserID TEXT," +
            "Phone TEXT," +
            "Address TEXT," +
            "Sex INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PAPER = "CREATE TABLE tbl_paper (" +
            "PaperID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Title_paper TEXT," +
            "Text1_paper TEXT," +
            "Text2_paper TEXT," +
            "Img_paper TEXT," +
            "Time_paper TEXT," +
            "Date_paper TEXT," +
            "CategoryID INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE tbl_category (" +
            "CategoryID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Category_name TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_COMMENT = "CREATE TABLE tbl_comment (" +
            "CommentID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PaperID INTEGER," +
            "ProfileID INTEGER," +
            "Text_comment TEXT," +
            "Time_comment TEXT," +
            "Date_comment TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PAPERSAVE = "CREATE TABLE tbl_paperSave (" +
            "PaperSaveID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PaperID INTEGER," +
            "ProfileID INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_CATEGORYFL = "CREATE TABLE tbl_categoryFL (" +
            "CategoryFLID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CategoryID INTEGER," +
            "ProfileID INTEGER," +
            "Description TEXT);";
    private static final String insertAdminUser = "INSERT INTO tbl_account (UserID, Password, Description) VALUES ('Admin@gmail.com', '111', '')";
    private static final String insertPaperFirst = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:11','22/02/2024',1,'')";
    private static final String insertPaperFirst1 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 10.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:11','22/02/2024',1,'')";
    private static final String insertCategory = "INSERT INTO tbl_category (Category_name, Description) VALUES ('Thể Thao', '')";
    private static final String insertCategory1 = "INSERT INTO tbl_category (Category_name, Description) VALUES ('Chính Trị', '')";
    private static final String insertCategory2 = "INSERT INTO tbl_category (Category_name, Description) VALUES ('Kinh Tế', '')";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ACCOUNT);
        db.execSQL(CREATE_TABLE_PROFILE);
        db.execSQL(CREATE_TABLE_PAPER);
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_PAPERSAVE);
        db.execSQL(CREATE_TABLE_COMMENT);
        db.execSQL(CREATE_TABLE_CATEGORYFL);
        db.execSQL(insertAdminUser);
        db.execSQL(insertPaperFirst);
        db.execSQL(insertCategory);
        db.execSQL(insertCategory1);
        db.execSQL(insertCategory2);
        String Sql = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 10.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:11','22/02/2024',1,'')";
        db.execSQL(Sql);
        String Sql1 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 10.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:11','22/02/2024',1,'')";
        db.execSQL(Sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
