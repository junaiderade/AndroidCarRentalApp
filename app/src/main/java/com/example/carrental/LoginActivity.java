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
        login();

        goToSignUp =(Button) findViewById(R.id.signUp);
        goToSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent signUpPage = new Intent(LoginActivity.this, SignUp.class);
              startActivity(signUpPage);


           }
        });
    }

    public void login(){
        Button user =(Button) findViewById(R.id.button5);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContactDataSource ds = new ContactDataSource(LoginActivity.this);
                EditText username= (EditText)findViewById(R.id.editText9);
                EditText password= (EditText)findViewById(R.id.editText10);
                String use= username.getText().toString();
                String pass= password.getText().toString();
                if(use.length()==0 || pass.length()==0)
                    return;

                User customer= new User(use,pass);

                if(ds.confirmUser(customer)==false){
                    return;
                }else{
                    Intent menuPage = new Intent(LoginActivity.this, ViewListings.class);
                    startActivity(menuPage);
                }
            }
        });
    }
}

