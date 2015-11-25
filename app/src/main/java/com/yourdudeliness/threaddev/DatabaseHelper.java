package com.yourdudeliness.threaddev;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by EROBOS on 11/22/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    //Database info
    private static final String DATABASE_NAME = "Database";
    private static final int DATABASE_VERSION = 1;

    //Table Names
    private static final String TABLE_MAIN = "main";
    private static final String TABLE_BUILDINGS = "buildings";
    private static final String TABLE_TROPHIES = "trophies";
    private static final String TABLE_PATHOSCOINS = "pathos coins";

    //Main Table Columns
    private static final String KEY_MAIN_CURR_SCORE = "score";
    private static final String KEY_MAIN_CURR_CLICK_VALUE = "curr click value";
    private static final String KEY_MAIN_BASE_CLICK_VALUE = "base click value";
    private static final String KEY_MAIN_CURR_PASSIVE = "passive";
    private static final String KEY_MAIN_CURR_PASSIVE_MANA = "passive mana";

    //Buildings Table Columns
    private static final String KEY_BUILDING_TYPE = "type";
    private static final String KEY_BUILDING_TOTAL = "totalBuildings";
    private static final String KEY_BUILDING_COST_OF_NEXT = "cost of next";
    private static final String KEY_BUILDING_BASE_PASSIVE = "base passive";
    private static final String KEY_BUILDING_CUMULATIVE_PASSIVE = "cumulative passive";


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MAIN_TABLE = "CREATE TABLE" + TABLE_MAIN +
                "(" + KEY_MAIN_CURR_SCORE + "INTEGER PRIMARY KEY," +
                KEY_MAIN_CURR_PASSIVE + " INTEGER  " +
                KEY_MAIN_BASE_CLICK_VALUE + " INTEGER  " +
                KEY_MAIN_CURR_CLICK_VALUE + " INTEGER " +
                KEY_MAIN_CURR_PASSIVE_MANA + " INTEGER " + ")";

        db.execSQL(CREATE_MAIN_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS" + "TABLE_MAIN");
            onCreate(db);
        }
    }
    public static synchronized DatabaseHelper getInstance(Context context) {

        if(sInstance == null){
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
    public void addPost
}
