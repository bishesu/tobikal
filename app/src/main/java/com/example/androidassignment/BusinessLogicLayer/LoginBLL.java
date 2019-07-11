package com.example.androidassignment.BusinessLogicLayer;

import com.example.androidassignment.APIs.GetImage;
import com.example.androidassignment.APIs.LoginRegisterApi;
import com.example.androidassignment.LoginRegister;
import com.example.androidassignment.Retrofit.Url;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginBLL {

        private String username;
        private String password;
        LoginRegisterApi loginRegisterApi;
        Url url;

        public LoginBLL(String username, String password){
            this.username = username;
            this.password = password;
        }
        private void instance(){
            Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            loginRegisterApi=  retrofit.create(LoginRegisterApi.class);


        }

    }
