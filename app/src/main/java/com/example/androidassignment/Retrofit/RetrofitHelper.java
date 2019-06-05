package com.example.androidassignment.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static Retrofit retrofit;

    public static Retrofit instance (){
            if (retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl(Url.Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
            }
            return  retrofit;
    }
}
