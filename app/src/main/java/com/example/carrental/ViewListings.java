package com.example.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewListings  extends AppCompatActivity {
    ArrayList<Car> car;


    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_listings);
        final ContactDataSource ds = new ContactDataSource(this);
        try{
            ds.open();
            car = ds.getCar();


            ds.close();
            ListView listView = (ListView)findViewById(R.id.lvContacts);
            adapter = new ContactAdapter(this, car);

            listView.setAdapter(adapter);
        }
        catch(Exception e){
            Toast.makeText(this, "Error retrieving cars", Toast.LENGTH_LONG).show();
        }
        final TextView tx = (TextView) findViewById(R.id.dates);
        Button menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ds.setDate(tx.getText().toString());
            }
        });

    }
}
