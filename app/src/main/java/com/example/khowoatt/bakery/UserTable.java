package com.example.khowoatt.bakery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 21/4/2560.
 */

public class UserTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String USER_TABLE = "userTable";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE = "Phone";
    public static final String COLUMN_ADDRESS = "Address";

    public UserTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewUser(String strUser, String strPassword, String strName, String strPhone, String strAddress){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUser);
        objContentValues.put(COLUMN_PASSWORD,strPassword);
        objContentValues.put(COLUMN_NAME,strName);
        objContentValues.put(COLUMN_PHONE,strPhone);
        objContentValues.put(COLUMN_ADDRESS,strAddress);
        return readSqLiteDatabase.insert(USER_TABLE,null, objContentValues);
    }
}



