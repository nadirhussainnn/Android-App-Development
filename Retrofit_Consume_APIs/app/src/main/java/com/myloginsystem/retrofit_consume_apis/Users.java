package com.myloginsystem.retrofit_consume_apis;

import com.google.gson.annotations.SerializedName;

public class Users {

    private String username, email, id, phone;

    public String getUserName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
}
