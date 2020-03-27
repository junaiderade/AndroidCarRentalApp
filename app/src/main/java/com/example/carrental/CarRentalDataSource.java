package com.example.carrental;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CarRentalDataSource {
    public SQLiteDatabase database;
    public CarRentalDatabaseHelper dbHelper;

   /* public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(String user, String password){
        boolean didSucced = false;
        CarRentalDataSource ds = new CarRentalDataSource();

        try{
            ds.open();

            ContentValues initialValues = new ContentValues();
            initialValues.put("username",user);
            initialValues.put("password",user);
            initialValues.put("usertype",1);
            didSucced=database.insert("user", null, initialValues) > 0;

        }catch (Exception e){
            e.printStackTrace();

        }
        ds.close();
        return didSucced;
    }*/
}

