package com.example.androidassignment;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Shufflefragment.OnFragmentInteractionListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        viewPager = findViewById(R.id.aview_pager);
        tabLayout = findViewById(R.id.atabId);

        AdapterMainActivity adapterMainActivity = new AdapterMainActivity(getSupportFragmentManager());
        adapterMainActivity.addFragment(new CategoriesFragment(), "categories");
        adapterMainActivity.addFragment(new Shufflefragment(), "shuffle");


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
                Toast.makeText(this, " redirecting to login/register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginRegister.class);
                startActivity(intent);
                break;
            case R.id.about_id:
                Toast.makeText(this, " redirecting to about", Toast.LENGTH_SHORT).show();

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
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
