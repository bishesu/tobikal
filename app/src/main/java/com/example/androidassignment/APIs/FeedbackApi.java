package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.FeedbackModel;
import com.example.androidassignment.Model.RegestrationModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FeedbackApi {
@FormUrlEncoded
    @POST("/feedback")
     Call<String> sendfeedback(
            @Field("fullname") java.lang.String fullname,
            @Field("description") java.lang.String description,
            @Field("email") java.lang.String email,
            @Field("contact") java.lang.String contact);;
}
