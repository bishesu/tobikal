package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.RegestrationModel;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginRegisterApi {
    @FormUrlEncoded
    @POST("/register")
    Call<String> addUser(@Field("firstname") String firstname,@Field("lastname") String lastname, @Field("email") String email, @Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("/login")
    Call<Token> getUser (@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("updateprofile/{id}")
    Call<Void> updateProfile(@Path("id") String id,@Body UserModel userModel);

}
