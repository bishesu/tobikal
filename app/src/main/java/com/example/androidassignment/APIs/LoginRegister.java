package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.RegestrationModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginRegister {

    @POST("/addUser")
    Call<Void> addUser(@Body RegestrationModel regestrationModel);

    @FormUrlEncoded
    @POST("getUser")
    Call<String> getUser (@Field("username") String username, @Field("password") String password);


}
