package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.RegestrationModel;
import com.example.androidassignment.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginRegisterApi {

    @POST("/register")
    Call<Void> addUser(@Body RegestrationModel regestrationModel);

    @FormUrlEncoded
    @POST("/login")
    Call<UserModel> getUser (@Field("username") String username, @Field("password") String password);


}
