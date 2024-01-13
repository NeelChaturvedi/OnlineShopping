package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String userDB = "UserData.db";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    public UserDBHelper(Context context) {
        super(context, userDB, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table userdata(Name TEXT primary key, Contact TEXT, Email TEXT, Address TEXT, DOB TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("drop table if exists userdata");
        onCreate(database);
    }

    public boolean insertData(String Name, String Contact, String Email, String Address, String DOB) {
        SQLiteDatabase authDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", Name);
        contentValues.put("Contact", Contact);
        contentValues.put("Email", Email);
        contentValues.put("Address", Address);
        contentValues.put("DOB", DOB);

        long result = authDB.insert("userdata", null, contentValues);
        authDB.close();
        return result != -1;
    }

    public boolean checkUserinfo(String email) {
        SQLiteDatabase authDB = this.getReadableDatabase(); // Use getReadableDatabase since we're not modifying data
        Cursor cursor = authDB.rawQuery("select * from userdata where Email = ?", new String[]{email});
        boolean userExists = cursor.getCount() > 0;
        cursor.close();
        authDB.close();
        return userExists;
    }

    public boolean checkUserinfo(String name, int contact, String email, String address, String dob) {
        SQLiteDatabase authDB = this.getWritableDatabase();
        Cursor cursor = authDB.rawQuery("select * from userdata where Name = ? and Contact = ? and Email = ? and Address = ? and DOB = ?", new String[]{name, String.valueOf(contact),email,address,dob});
        boolean userExists = cursor.getCount() > 0;
        cursor.close(); // Close the cursor
        authDB.close(); // Close the database
        return userExists;
    }


    public User getUserByEmail(String email) {
        SQLiteDatabase authDB = this.getReadableDatabase();
        User user = null;

        Cursor cursor = authDB.query("userdata", null, "Email=?", new String[]{email}, null, null, null);

        if (cursor.moveToFirst()){
            int nameColumnIndex = cursor.getColumnIndex("Name");
            int contactColumnIndex = cursor.getColumnIndex("Contact");
            int addressColumnIndex = cursor.getColumnIndex("Address");
            int dobColumnIndex = cursor.getColumnIndex("DOB");

            if (nameColumnIndex >= 0 && contactColumnIndex >= 0 && addressColumnIndex >= 0 && dobColumnIndex >= 0) {
                String name = cursor.getString(nameColumnIndex);
                String contact = cursor.getString(contactColumnIndex);
                String address = cursor.getString(addressColumnIndex);
                String dob = cursor.getString(dobColumnIndex);

                user = new User(name, contact, email, address, dob);
            }
        }

        cursor.close();
        authDB.close();

        return user;
    }
}
