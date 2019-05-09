package com.example.androidassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent  = new Intent(Splashscreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
