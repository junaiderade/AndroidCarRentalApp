package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
public class LoginActivity extends AppCompatActivity {

    private Button goToSignUp;
    CarRentalDatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db= new CarRentalDatabaseHelper(this);
        Log.w("hello","yuuuuuuuuu");

        goToSignUp =(Button) findViewById(R.id.signUp);
        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpPage = new Intent(LoginActivity.this, SignUp.class);
                startActivity(signUpPage);

            }
        });
    }
}

