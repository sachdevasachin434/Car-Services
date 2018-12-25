package com.example.sachd.countingcars;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CCDB extends SQLiteOpenHelper{
    public static final String KEY_NAME="_Name";
    public static final String KEY_MAIL="_Mail";
    public static final String KEY_MOBILE="_Mobile";
    public static final String KEY_USERID="_UserID";
    public static final String KEY_PASSWORD="_Password";

    private static final String DATABASE_NAME = "CountingCarsDB";
    private static final String DATABASE_TABLE = "UserTable";
    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase db;


    public CCDB(Context c) {
        super(c, DATABASE_NAME , null , DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        //String st="create table user " + "(Name TEXT,Email TEXT,Mobile TEXT,UserId TEXT PRIMARY KEY,Password TEXT);";
        db.execSQL("create table user(username varchar(40) primary key, password varchar(40) not null, email varchar(80), name varchar(40), mobile int(12));");
        //SignUp s=new SignUp();
        /*db.execSQL("INSERT INTO user(id,name,roll) VALUES (1,'sachin',312);");
        db.execSQL("INSERT INTO user(id,name,roll) VALUES (2,'rohit',306);");
        db.execSQL("INSERT INTO user(id,name,roll) VALUES (3,'saadgi',309);");*/
        //db.execSQL("INSERT INTO user(Name,Email,Mobile,UserId,Password) VALUES (s.str1,s.str2,s.str3,s.str4,s.str5);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if EXISTS user");
        onCreate(db);
    }

}
