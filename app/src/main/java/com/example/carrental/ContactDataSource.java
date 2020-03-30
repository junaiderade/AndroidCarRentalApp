package com.example.carrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

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
    public boolean insertCar(Car car){
        boolean didSucced = false;


        try{

            ContentValues initialValues = new ContentValues();
            initialValues.put("carName",car.getCarName());
            initialValues.put("mpg",car.getMpg());
            initialValues.put("carType",car.getCarType());
            initialValues.put("price",car.getPrice());
            if(car.getPicture() != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                car.getPicture().compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] photo = baos.toByteArray();
                initialValues.put("photo", photo);
            }
            didSucced=database.insert("car", null, initialValues) > 0;
            car.setCarId(didSucced?0:-1);


        }catch (Exception e){
            e.printStackTrace();

        }
        return didSucced;
    }
}

