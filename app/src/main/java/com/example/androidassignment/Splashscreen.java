package com.example.androidassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Splashscreen extends AppCompatActivity {
    SharedPreferences preferences;
    Boolean isloggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences=getSharedPreferences("User",0);
        isloggedin=preferences.getBoolean("isloggedin",false);

        if(isloggedin)
        {
            final Intent intent=new Intent(Splashscreen.this,MainActivity.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            },2000);
        }
        else
        {
            final Intent intent=new Intent(Splashscreen.this,LoginRegister.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            },2000);
        }
    }
}
