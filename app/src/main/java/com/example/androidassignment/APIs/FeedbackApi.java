package com.example.androidassignment.APIs;

import com.example.androidassignment.Model.FeedbackModel;
import com.example.androidassignment.Model.RegestrationModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FeedbackApi {

    @POST("/feedback")
    Call<String> sendfeedback(@Body FeedbackModel feedbackModel);
}
