package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetImage {
    @GET("/get_individual_user_image_android/{id}")
    Call<List<Cell>> getImages(@Path("id") String userid
    );


}
