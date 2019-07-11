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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.androidassignment.APIs.GetImage;
import com.example.androidassignment.Adapter.ProfileGalleryAdapter;
import com.example.androidassignment.Model.Cell;
import com.example.androidassignment.Model.Token;
import com.example.androidassignment.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity  {
//    NavigationView navigationView;
//    MenuItem menuItem1;
//    MenuItem menuItem2;

private RecyclerView recyclerView;
 TextView username;
 TextView email;
 TextView contact;
 TextView lastname;
 TextView firstname;
GetImage getImage;

Button update;
Cell cell;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance();

//        navigationView=findViewById(R.id.navigation_view);


        username=findViewById(R.id.tvusernameprofile);
        firstname = findViewById(R.id.firstnameupdateptrofile);
        lastname = findViewById(R.id.lastnameupdateptrofile);
        email=findViewById(R.id.emailupdateptrofile);
        contact=findViewById(R.id.contactupdateptrofile);
        update=findViewById(R.id.btnupdateuserprofile);
//        upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////               Intent intent = new Intent(Profile.this, Uploadimage.class);
////               startActivity(intent);
////                Toast.makeText(Profile.this, "pass", Toast.LENGTH_SHORT).show();
//            }
//        });
//        update=findViewById(R.id.btnupdateprofile);
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(Profile.this, Updateprofile.class );
//                startActivity(intent1);
//            }
//        });


//        navigationView.setNavigationItemSelectedListener(this);

        setContentView(R.layout.activity_profile);
        SharedPreferences preferences=this.getSharedPreferences("tokenstore",0);
        String userid=preferences.getString("userId",null);
        String token = preferences.getString("token","");
        Toast.makeText(Profile.this,token,Toast.LENGTH_LONG).show();

//        recyclerView=findViewById(R.id.gallery);

      Log.d("usreid",userid);
        Call<UserResponse> calla=getImage.profileDetail(token);
        calla.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    String name = response.body().getData().getFirstname();
                   String lname = response.body().getData().getLastname();
                   String email = response.body().getData().getEmail();
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
        getImage=retrofit.create(GetImage.class);


    }


}
