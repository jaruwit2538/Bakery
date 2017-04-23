package com.example.khowoatt.bakery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 23/4/2560.
 */

public class BakeryTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String BAKERY_TABLE = "bakeryTable";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_BAKERY = "Bakery";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";

    public BakeryTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewBakery(String strBakery, String strSource, String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_BAKERY,strBakery);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);
        return readSqLiteDatabase.insert(BAKERY_TABLE,null, objContentValues);
    }
}
