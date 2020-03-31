package com.example.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListings  extends AppCompatActivity {
    ArrayList<Car> car;


    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_listings);
        ContactDataSource ds = new ContactDataSource(this);
        try{
            ds.open();
            car = ds.getCar();

            Log.w("hello",car.size()+"");

            ds.close();
            ListView listView = (ListView)findViewById(R.id.lvContacts);
            adapter = new ContactAdapter(this, car);

            listView.setAdapter(adapter);
        }
        catch(Exception e){
            Toast.makeText(this, "Error retrieving contacts", Toast.LENGTH_LONG).show();
        }
        Button menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent =new Intent(ViewListings.this,Menu.class);
                startActivity(intent);

            }
        });

    }
}
