package com.csab.daggermvpstarter.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper {

    // General database information
    public static String DATABASE_NAME = "notes.db";
    private static int DATABASE_VERSION = 1;
    public static String COL_ID = BaseColumns._ID;

    // Note table information
    public static String NOTE_TABLE = "note";
    public static String COL_CONTENTS = "contents";
    public static String COL_CREATED_DATE = "created_date";
    public static String[] NOTE_COLUMNS = { COL_ID, COL_CONTENTS, COL_CREATED_DATE };

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NOTE_TABLE + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_CONTENTS + " TEXT,"
                + COL_CREATED_DATE + " TEXT"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOTE_TABLE + ";");
        onCreate(db);
    }
}