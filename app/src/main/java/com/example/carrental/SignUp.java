package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class SignUp extends AppCompatActivity {

    private Button goToMenu;
   private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        CarRentalDataSource ds = new CarRentalDataSource();

        goToMenu =(Button) findViewById(R.id.createAccount);
        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menuPage = new Intent(SignUp.this, Menu.class);
                startActivity(menuPage);
            }
        });



    }

}
