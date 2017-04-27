package com.example.khowoatt.bakery.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 27/4/2560.
 */

public class DrinkTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String DRINK_TABLE = "drinkTable";
    public static final String COLUMN_ID_DRINK = "_id";
    public static final String COLUMN_DRINK = "drink";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";

    public DrinkTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewDrink(String strDrink, String strSource, String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_DRINK,strDrink);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);
        return readSqLiteDatabase.insert(DRINK_TABLE,null, objContentValues);
    }
}
