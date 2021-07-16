package com.example.wefish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class FishDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DB_NAME = "FISH.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "fishes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_WEIGHT = "WEIGHT";
    private static final String COLUMN_HEIGHT = "HEIGHT";


    public FishDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_createTable = " CREATE TABLE " + TABLE_NAME + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, "+
                COLUMN_WEIGHT + " TEXT, "+
                COLUMN_HEIGHT + " INTEGER)";

        db.execSQL(query_createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }


    public void addFish(String name, String weight, int height){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues fishValues = new ContentValues();

        fishValues.put(COLUMN_NAME, name);
        fishValues.put(COLUMN_WEIGHT, weight);
        fishValues.put(COLUMN_HEIGHT, height);

        db.insert(TABLE_NAME, null, fishValues);
    }

    public Cursor readFishes(){
        String query_returnAll = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query_returnAll, null);
        }

        return cursor;
    }

    public void updateFish(String selectedFishId, String name, String weight, String height){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues fishValues = new ContentValues();

        fishValues.put(COLUMN_NAME, name);
        fishValues.put(COLUMN_WEIGHT, weight);
        fishValues.put(COLUMN_HEIGHT, height);

        db.update(TABLE_NAME, fishValues, COLUMN_ID+" = ?",  new String[]{selectedFishId});
    }

    public void deleteTheFish(String selectedFishId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID+ " = ?", new String[]{selectedFishId});
    }

    public void deleteAllFishes(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}

