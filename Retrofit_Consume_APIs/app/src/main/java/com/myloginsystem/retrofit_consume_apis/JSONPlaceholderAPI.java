package com.myloginsystem.retrofit_consume_apis;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderAPI {

    @GET("users")
    Call<List<Users>> getUsers();

    //Place url endpoint leaving base url in @GET Annotation i.e
    //https://jsonplaceholder.typicode.com/users   has users

}
