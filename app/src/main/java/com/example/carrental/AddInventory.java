package com.example.carrental;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;


public class AddInventory extends AppCompatActivity {
    final int PERMISSION_REQUEST_CAMERA = 103;
    final int CAMERA_REQUEST = 1888;
    private Car car;
    Bitmap carPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_vehicle);
        add();
        initImageButton();


    }


    public void add(){
        Button add = (Button) findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContactDataSource ds = new ContactDataSource(AddInventory.this);
                EditText carName= (EditText) findViewById(R.id.editText);
                EditText mpg =  (EditText) findViewById(R.id.editText2);
                EditText carType =  (EditText) findViewById(R.id.editText3);
                EditText price =  (EditText) findViewById(R.id.editPrice);
                Integer priceInt = new Integer(price.getText().toString());
                Integer mpgInt = new Integer(price.getText().toString());



                 car= new Car(carName.getText().toString(),carType.getText().toString(),mpgInt,priceInt);
                try{
                    ds.open();
                    car.setPicture(carPicture);
                    ds.insertCar(car);
                    ds.close();

                }catch(Exception ex){

                }
                if(car.getCarId()!=-1){
                    Toast.makeText(AddInventory.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(AddInventory.this,Menu.class);
                    startActivity(intent);
                }else {

                    Toast.makeText(AddInventory.this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void initImageButton() {
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ContextCompat.checkSelfPermission(AddInventory.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(AddInventory.this, android.Manifest.permission.CAMERA)) {
                            Snackbar.make(findViewById(R.id.add_vehicle), "The app needs permission to take pictures.", Snackbar.LENGTH_INDEFINITE).setAction("Ok", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ActivityCompat.requestPermissions(AddInventory.this, new String[]{ android.Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
                                }
                            }).show();
                        } else {
                            ActivityCompat.requestPermissions(AddInventory.this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
                        }
                    }
                    else {
                        takePhoto();
                    }
                } else {
                    takePhoto();
                }
            }
        });
    }
    public void takePhoto(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Bitmap scaledPhoto = Bitmap.createScaledBitmap(photo, 200, 200, true);
                ImageButton imageContact = (ImageButton) findViewById(R.id.imageButton);
                imageContact.setImageBitmap(scaledPhoto);

                    carPicture = scaledPhoto;

            }
        }
    }

}
