package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.Handler;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable(){ //This method handles the splash screen
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }



}
