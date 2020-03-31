package com.example.carrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ContactDataSource {
    public static String username = "";
    public static long isAdmin = 1;
    public SQLiteDatabase database;
    public CarRentalDatabaseHelper dbHelper;
    public ContactDataSource(Context context) {
        dbHelper = new CarRentalDatabaseHelper(context);
    }
    public static long getIsAdmin(){
        return isAdmin;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public boolean confirmUser(User user){
        String sql = "Select count(*) from user where username = '"+user.getUsername()+"'and password='"+user.getPassword()+"'";
        SQLiteStatement statement = dbHelper.getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();

        if(l != 0){
            String ut = "Select usertype from user where username = '"+user.getUsername()+"'and password='"+user.getPassword()+"'";
            SQLiteStatement statement2 = dbHelper.getReadableDatabase().compileStatement(ut);
            l = statement2.simpleQueryForLong();
            isAdmin = l;
            username = user.getUsername();
            Log.d("login", "yo +"+ isAdmin);

            return true;
        }
        return false;
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
    public ArrayList<Car> getCar() {

        ArrayList<Car> cars = new ArrayList<Car>();
        try {
            String query = "SELECT * FROM car ";
            Cursor cursor = database.rawQuery(query, null);

            Car newCar;
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                newCar = new Car();
                newCar.setCarId(cursor.getInt(0));
                newCar.setCarName(cursor.getString(1));
                newCar.setMpg(cursor.getInt(2));
                newCar.setCarType(cursor.getString(3));
                newCar.setPrice(cursor.getInt(4));


                if(cursor.getBlob(5) != null) {
                    byte[] byteArray = cursor.getBlob(5);
                    Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
                    newCar.setPicture(bm);

                }
                cars.add(newCar);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e){
            cars = new ArrayList<Car>();
        }
        return cars;
    }
}

