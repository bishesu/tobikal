package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.ImgModel;
import com.example.androidassignment.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GetImage {
    @GET("/get_individual_user_image_android/{id}")
    Call<List<ImgModel>> getImages(@Path("id") String userid
    );

    @GET("/profile")
    Call<UserResponse> profileDetail(@Header("Authorization") String token);

    @GET("/get_all_user_image")
    Call<List<ImgModel>> getAllImages();

}
