package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        viewListings();
        adminPage();

    }

    public void viewListings(){
        ImageButton user =(ImageButton) findViewById(R.id.imageButton2);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent menuPage = new Intent(Menu.this, ViewListings.class);
                    startActivity(menuPage);
            }
        });
    }
    public void adminPage(){
        ImageButton user =(ImageButton) findViewById(R.id.imageAdmin);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuPage = new Intent(Menu.this, AdminPage.class);
                startActivity(menuPage);
            }
        });
    }


}
