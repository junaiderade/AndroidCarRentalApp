package com.example.carrental;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class AdminPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        addVehicle();
        menu();

    }
    public void addVehicle(){
        Button menu = (Button) findViewById(R.id.button2);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent =new Intent(AdminPage.this,AddInventory.class);
                startActivity(intent);

            }
        });
    }
    public void menu(){
        Button menu = (Button) findViewById(R.id.button3);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent =new Intent(AdminPage.this,Menu.class);
                startActivity(intent);

            }
        });
    }

}
