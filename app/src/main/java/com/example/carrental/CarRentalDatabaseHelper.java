package com.example.carrental;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class CarRentalDatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_USER = "CarRental.db";

    private static final int DATABASE_VERSION = 6;

    private static final String CREATE_TABLE_USER =
            "create table user (_id integer primary key autoincrement, "
                    + "username text not null, password text, "
                    + "usertype integer);";
    private static final String CREATE_TABLE_CAR =
            "create table car (_idCar integer primary key autoincrement, "
                    + "carName text not null, mpg text, "
                    + "carType text, price integer, photo blob );";
    private static final String CREATE_TABLE_Reservation =
            "create table reservation (userId integer, "
                    + "username text not null, carName text, "
                    + "date text );";





    public CarRentalDatabaseHelper(Context context){
        super(context, DATABASE_USER,null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL( CREATE_TABLE_USER);
        Log.w("hello","Chooochooo");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS user" );
        db.execSQL( CREATE_TABLE_USER);
        db.execSQL( CREATE_TABLE_CAR);
        db.execSQL( CREATE_TABLE_Reservation);
    }

}