package com.example.androidassignment;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

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
private RecyclerView recyclerView;
GetImage getImage;
Cell cell;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance();
        setContentView(R.layout.activity_profile);
        SharedPreferences preferences=this.getSharedPreferences("tokenstore",0);
        String id=preferences.getString("userId",null);
        System.out.println("bises iddadas: "+id);
        recyclerView=findViewById(R.id.gallery);
        recyclerView.setLayoutManager(new GridLayoutManager(Profile.this,3));
        System.out.println("id"+id);
        Call<List<Cell>> calla=getImage.getImages(id);
        calla.enqueue(new Callback<List<Cell>>() {
            @Override
            public void onResponse(Call<List<Cell>> call, Response<List<Cell>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Profile.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Cell> images=response.body();
                System.out.println("thegnachos"+response.body());
                recyclerView.setAdapter(new ProfileGalleryAdapter(getApplicationContext(),images));
            }

            @Override
            public void onFailure(Call<List<Cell>> call, Throwable t) {
                Toast.makeText(Profile.this, "Errot "+t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("nachos:"+t.getMessage());
            }
        });
    }

    private void instance(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create()).build();
        getImage=retrofit.create(GetImage.class);
    }
}
