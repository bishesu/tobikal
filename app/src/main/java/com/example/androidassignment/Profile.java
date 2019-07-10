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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity {
    NavigationView navigationView;
    MenuItem menuItem1;
    MenuItem menuItem2;

private RecyclerView recyclerView;
 TextView username;
 TextView email;
 TextView contact;
GetImage getImage;
Button upload;
Cell cell;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance();

        navigationView=findViewById(R.id.navigation_view);

        username=findViewById(R.id.tvusernameprofile);
        email=findViewById(R.id.tvemailprofile);
        contact=findViewById(R.id.tvcontactprofile);
        upload=findViewById(R.id.btnupload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Updateprofile.class);
                startActivity(intent);
            }
        });

//        navigationView.setNavigationItemSelectedListener(this);

        setContentView(R.layout.activity_profile);
        SharedPreferences preferences=this.getSharedPreferences("tokenstore",0);
        String userid=preferences.getString("userId",null);

        recyclerView=findViewById(R.id.gallery);

      Log.d("usreid",userid);
        Call<List<Cell>> calla=getImage.getImages(userid);

        calla.enqueue(new Callback<List<Cell>>() {
            @Override
            public void onResponse(Call<List<Cell>> call, Response<List<Cell>> response) {

                List<Cell> images=response.body();

                recyclerView.setAdapter(new ProfileGalleryAdapter(getApplicationContext(),images));
                recyclerView.setLayoutManager(new GridLayoutManager(Profile.this,2));

            }

            @Override
            public void onFailure(Call<List<Cell>> call, Throwable t) {

                Toast.makeText(Profile.this, "Errot "+t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("nachos:"+t.getMessage());
            }
        });
    }

    private void instance(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        getImage=retrofit.create(GetImage.class);


    }


}
