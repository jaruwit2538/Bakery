package com.example.khowoatt.bakery.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 27/4/2560.
 */

public class CakeTable { private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String CAKE_TABLE = "cakeTable";
    public static final String COLUMN_ID_CAKE = "_id";
    public static final String COLUMN_CAKE = "drink";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";

    public CakeTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewCake(String strCake, String strSource, String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CAKE,strCake);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);
        return readSqLiteDatabase.insert(CAKE_TABLE,null, objContentValues);
    }
}
