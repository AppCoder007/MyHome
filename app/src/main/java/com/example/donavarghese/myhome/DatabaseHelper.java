package com.example.donavarghese.myhome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE User_Data(_id INTEGER PRIMARY KEY,FULLNAME TEXT,AGE INTEGER,EMAIL TEXT,USERNAME TEXT,PASSWORD TEXT,HINT TEXT,IPADDRESS TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
