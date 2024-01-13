package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DBname = "Register.db";
    private static final int databaseVersion = 1;

    public DBhelper(@Nullable Context context) {
        super(context, DBname, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(Email TEXT primary key, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    public boolean insertData(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", email); // Use "Email" instead of "User"
        contentValues.put("Password", password); // Use "Password" instead of "password"

        long result = myDB.insert("users", null, contentValues);
        myDB.close(); // Close the database
        return result != -1;
    }

    public boolean checkUser(String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where Email = ?", new String[]{email}); // Use "Email" instead of "email"
        boolean userExists = cursor.getCount() > 0;
        cursor.close(); // Close the cursor
        myDB.close(); // Close the database
        return userExists;
    }

    public boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where Email = ? and Password = ?", new String[]{email, password}); // Use "Email" and "Password" instead of "email" and "password"
        boolean userExists = cursor.getCount() > 0;
        cursor.close(); // Close the cursor
        myDB.close(); // Close the database
        return userExists;
    }
}
