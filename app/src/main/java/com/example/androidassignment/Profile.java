package com.example.androidassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.androidassignment.APIs.GetImage;
import com.example.androidassignment.APIs.LoginRegisterApi;
import com.example.androidassignment.Adapter.ProfileGalleryAdapter;
import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.Model.UserModel;
import com.example.androidassignment.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity implements View.OnClickListener {
//    NavigationView navigationView;
//    MenuItem menuItem1;
//    MenuItem menuItem2;

private RecyclerView recyclerView;
 TextView username;
 EditText uid;
 EditText contact;
 EditText lastname;
 EditText firstname;
GetImage getImage;

Button update;
Cell cell;
ImageView img;
LoginRegisterApi loginRegisterApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance();

//        navigationView=findViewById(R.id.navigation_view);



        setContentView(R.layout.activity_profile);
        SharedPreferences preferences=this.getSharedPreferences("tokenstore",0);
        String userid=preferences.getString("userId","");
        uid.setText(userid);
        String token = preferences.getString("token","");
        Toast.makeText(Profile.this,token,Toast.LENGTH_LONG).show();

        firstname = findViewById(R.id.firstnameprofile);
        lastname = findViewById(R.id.lastnameptrofile);
uid  = findViewById(R.id.id);
        contact=findViewById(R.id.contactprofile);
        update=findViewById(R.id.btnupdateprofile);
        username=findViewById(R.id.tvusernameprofile);



//        recyclerView=findViewById(R.id.gallery);

      Log.d("usreid",userid);
        Call<UserResponse> calla=getImage.profileDetail(token);
        calla.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    String name = response.body().getData().getFirstname();
                   String lname = response.body().getData().getLastname();
                   String contactw = response.body().getData().getContact();
                   String usernamee=response.body().getData().getUsername();


                    firstname.setText(name);
                    lastname.setText(lname);
                    contact.setText(contactw);
                    username.setText(usernamee);



                    Toast.makeText(Profile.this,response.body().getData().getEmail(),Toast.LENGTH_LONG).show();

//                   username.setText(email);

                }else{
                    Toast.makeText(Profile.this,"fail",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }

    private void instance(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        loginRegisterApi=retrofit.create(LoginRegisterApi.class);


    }

    public void updateUser(){
        instance();
        String id=uid.getText().toString();
        String firstnamee=firstname.getText().toString();
        String lastnamee=lastname.getText().toString();
        String contactt=contact.getText().toString();


        UserModel user=new UserModel(firstnamee,lastnamee,"","",contactt,"","","","","");
        Call<Void> update=loginRegisterApi.updateProfile(id,user);
        update.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User data updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error"+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnupdateprofile){
            updateUser();
        }
    }
}
