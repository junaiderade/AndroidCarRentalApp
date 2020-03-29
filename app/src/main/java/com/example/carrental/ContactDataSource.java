package com.example.carrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ContactDataSource {
    public SQLiteDatabase database;
    public CarRentalDatabaseHelper dbHelper;
    public ContactDataSource(Context context) {
        dbHelper = new CarRentalDatabaseHelper(context);
    }


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(User user){
        boolean didSucced = false;


        try{

            ContentValues initialValues = new ContentValues();
            initialValues.put("username",user.getUsername());
            initialValues.put("password",user.getPassword());
            initialValues.put("usertype",user.getUsertype());
            didSucced=database.insert("user", null, initialValues) > 0;

        }catch (Exception e){
            e.printStackTrace();

        }
        user.setId(0);
        return didSucced;
    }
}

