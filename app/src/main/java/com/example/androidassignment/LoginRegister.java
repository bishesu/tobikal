package com.example.androidassignment;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.androidassignment.Adapter.Aadapterlogin;
import com.example.androidassignment.Fragments.LoginFragment;
import com.example.androidassignment.Fragments.RegisterFragment;

public class LoginRegister extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        tabLayout = findViewById(R.id.tabId);
        viewPager = findViewById(R.id.view_pager);

        Aadapterlogin adapter = new Aadapterlogin(getSupportFragmentManager());

        adapter.addFragment(new LoginFragment(),"Login");
        adapter.addFragment(new RegisterFragment(),"Register");


//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = findViewById(R.id.drawer_layout);
//
//        navigationView = findViewById(R.id.navigation_view);
//    navigationView.setNavigationItemSelectedListener(this);
//
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
//        drawerLayout.setDrawerListener(toggle);
//
//        toggle.syncState();


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}

