package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class SignUp extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        initUser();





    }
    public void initUser(){
        Button user =(Button) findViewById(R.id.createAccount);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContactDataSource ds = new ContactDataSource(SignUp.this);
                EditText username= (EditText)findViewById(R.id.editText9);
                EditText password= (EditText)findViewById(R.id.editText10);
                String use= username.getText().toString();
                String pass= password.getText().toString();
                if(use.length()==0 || pass.length()==0)
                    return;
                


                User customer= new User(use,pass);
                try{
                    ds.open();
                    ds.insertUser(customer);
                    ds.close();

                }catch(Exception ex){

                }
                if(customer.getId()!=-1) {


                    Intent menuPage = new Intent(SignUp.this, Menu.class);
                    startActivity(menuPage);
                }
            }
        });
    }
    }





