package com.example.khowoatt.bakery.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 21/4/2560.
 */

public class OrderTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String ORDER_TABLE = "orderTable";
    public static final String COLUMN_ID_ORDER = "_id";
    public static final String COLUMN_BAKERY = "Bakery";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_TOTALPRICE = "TotalPrice";
    public static final String COLUMN_OFFICER = "Officer";

    public OrderTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewOrder(String strOfficer,String strBakery, String strDate, String strTotalPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_BAKERY,strBakery);
        objContentValues.put(COLUMN_DATE,strDate);
        objContentValues.put(COLUMN_TOTALPRICE,strTotalPrice);
        objContentValues.put(COLUMN_OFFICER,strOfficer);
        return readSqLiteDatabase.insert(ORDER_TABLE,null, objContentValues);
    }
}