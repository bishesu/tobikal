package com.example.androidassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androidassignment.Adapter.AdapterMainActivity;
import com.example.androidassignment.Fragments.CategoriesFragment;
import com.example.androidassignment.Fragments.Shufflefragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    SensorManager sensorManager;
    private float dataAceelo;
    private float dataAceelocurrent;
    private float dataAceelolast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean isloggedin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        viewPager = findViewById(R.id.aview_pager);
        tabLayout = findViewById(R.id.atabId);
        shake();
        AdapterMainActivity adapterMainActivity = new AdapterMainActivity(getSupportFragmentManager());


        adapterMainActivity.addFragment(new Shufflefragment(), "Trending Images");
        adapterMainActivity.addFragment(new CategoriesFragment(), "Feedback");

        shake();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();

        viewPager.setAdapter(adapterMainActivity);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.login_id:
                Intent intent=new Intent(MainActivity.this,LoginRegister.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sharedPreferences=getSharedPreferences("User",0);
                editor=sharedPreferences.edit();
                editor.putBoolean("isloggedin",false).commit();
                startActivity(intent);
                finish();

                break;
            case R.id.about_id:

                Toast.makeText(this, " redirecting to about", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this,Aboutus.class);
                startActivity(intent3);

                break;
            case R.id.home_id:
                Toast.makeText(this, " redirecting to home", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);


                break;
            case R.id.profile_id:
                Toast.makeText(this, "redirecting to profile", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Profile.class);
                startActivity(intent2);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void shake(){
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener accellistener = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values=event.values;
                float xaxis=values[0];
                float yaxis=values[1];
                float zaxis=values[2];
                dataAceelolast=dataAceelocurrent;
                dataAceelocurrent=(float)Math.sqrt((double) (xaxis*xaxis+yaxis*yaxis+zaxis*zaxis));
                float delta=dataAceelocurrent-dataAceelolast;
                dataAceelo=dataAceelo*0.9f+delta;
                if(dataAceelo>10) {
                    Intent intent=new Intent(MainActivity.this,Aboutus.class);
                    startActivity(intent);
                    finish();

                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        if (sensor == null) {
            Toast.makeText(this, "No Accelometer sensor detected", Toast.LENGTH_SHORT).show();
        }
        else {
            sensorManager.registerListener(accellistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }



}
