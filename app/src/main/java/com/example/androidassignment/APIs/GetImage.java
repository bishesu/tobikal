package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetImage {

    @FormUrlEncoded
    @POST("/get_individual_image")
    Call<List<Cell>> getImages(@Field("id") String id);
}
