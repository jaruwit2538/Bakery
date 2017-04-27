package com.example.khowoatt.bakery.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by khowoatt on 21/4/2560.
 */

public class MySQLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Bakery1.db";//กำหนดชื่อไฟล์ Database
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "create table userTABLE"+//สร้าง Table
            "(_id integer primary key, User text, Password text, Name text, Phone text, Address text);";
    private static final String CREATE_BAKERY_TABLE = "create table bakeryTABLE"+
            "(_id integer primary key, Bakery text, Source text, Price text);";
    private static final String CREATE_ORDER_TABLE = "create table orderTABLE"+
            "(_id integer primary key, officer text ,Bakery text, Date text, TotalPrice text);";
    private static final String CREATE_DRINK_TABLE = "create table drinkTABLE"+
            "(_id integer primary key, Drink text ,Source text, Price text);";
    private static final String CREATE_CAKE_TABLE = "create table drinkTABLE"+
            "(_id integer primary key, Cake text ,Source text, Price text);";

    public MySQLite(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_BAKERY_TABLE);
        sqLiteDatabase.execSQL(CREATE_ORDER_TABLE);
        sqLiteDatabase.execSQL(CREATE_DRINK_TABLE);
        sqLiteDatabase.execSQL(CREATE_CAKE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
