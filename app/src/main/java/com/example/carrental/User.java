package com.example.carrental;

public class User {
    private int id=-1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public int getUsertype() {
        return usertype;
    }

    private int usertype=0;

    public User(String user,String pass){
        username = user;
        password=pass;
        if(user.contains("@juyu.rental.com")){
            usertype=1;
        }
    }
}
