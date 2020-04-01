package com.example.carrental;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewRes extends AppCompatActivity {
    CarRentalDatabaseHelper db;
    ContactDataSource ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewres);

        ListView lv = (ListView) findViewById(R.id.lv);
        db = new CarRentalDatabaseHelper(this);
        ds = new ContactDataSource(this);

        ArrayList<String>theList = new ArrayList<>();
        Cursor data = ds.getReservations();

        if(data.getCount() == 0){
            Toast.makeText(this, "You havnt reserved a car yet", Toast.LENGTH_LONG).show();

        }else{
            while(data.moveToNext()){
                theList.add("Car Name: "+data.getString(2)+" | Date: "+data.getString(3));
                ListAdapter lad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                lv.setAdapter(lad);
            }
        }

        
    }


}
