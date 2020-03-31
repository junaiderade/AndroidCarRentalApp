package com.example.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveInventory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_vehicle);

        menu();
        //remove();

    }
    public void menu(){
        Button menu = (Button) findViewById(R.id.mainButton4);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent =new Intent(RemoveInventory.this,Menu.class);
                startActivity(intent);

            }
        });
    }
    /*
    public void remove(){
        Button menu = (Button) findViewById(R.id.removeButton);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText carname=(EditText)findViewById(R.id.editText);
                if(carname.getText().toString().length()>0) {
                    ContactDataSource ds = new ContactDataSource(RemoveInventory.this);
                    if(!ds.deleteCar(carname.getText().toString())){
                        Toast.makeText(RemoveInventory.this, "Doesn't Exist", Toast.LENGTH_SHORT).show();

                        return;
                    }Toast.makeText(RemoveInventory.this, "Delete Sucessful", Toast.LENGTH_SHORT).show();



                    Intent intent = new Intent(RemoveInventory.this, Menu.class);
                    startActivity(intent);
                }
            }
        });
    }*/
            }