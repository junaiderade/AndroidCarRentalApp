package com.example.carrental;

import android.graphics.Bitmap;

public class Car {
    private int carId=-1;
    private int mpg;
    private String carName;
    private String carType;
    private int price;
    private Bitmap picture;

    public Car(String car,String type,int mpg,int price){
        this.carName= car;
        this.carType= type;
        this.mpg=mpg;
        this.price=price;

    }
    public Car(){


    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
