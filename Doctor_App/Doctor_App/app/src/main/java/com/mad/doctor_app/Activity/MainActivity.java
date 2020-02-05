package com.mad.doctor_app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.mad.doctor_app.Adapter.LoadGridDataAdapter;
import com.mad.doctor_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mdrawerLayout;
    ActionBarDrawerToggle drawerToggle;
    GridView gridView;
    Toolbar toolbar;
    ArrayList<Item> arrayList = new ArrayList<>();
    LoadGridDataAdapter loadGridDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar();

        navigation();

        arrayList.add(new Item("Neurologists", R.drawable.neuro));
        arrayList.add(new Item("Hematologists", R.drawable.hematology));
        arrayList.add(new Item("Allergists", R.drawable.allergists));
        arrayList.add(new Item("Oncologists", R.drawable.oncology));
        arrayList.add(new Item("Radiologists", R.drawable.radiology));
        arrayList.add(new Item("Urologists", R.drawable.urology));
        arrayList.add(new Item("Neurologists", R.drawable.neuro));
        arrayList.add(new Item("Hematologists", R.drawable.hematology));
        arrayList.add(new Item("Allergists", R.drawable.allergists));
        arrayList.add(new Item("Oncologists", R.drawable.oncology));
        arrayList.add(new Item("Radiologists", R.drawable.radiology));
        arrayList.add(new Item("Urologists", R.drawable.urology));

        loadGridDataAdapter = new LoadGridDataAdapter(this, R.layout.gridview_item, arrayList);
        gridView.setAdapter(loadGridDataAdapter);

    }

    private void init() {
        gridView = findViewById(R.id.grid_view);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        ImageView back_img = headerview.findViewById(R.id.nav_back_arrow);
        back_img.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                mdrawerLayout.closeDrawer(Gravity.START);
            }
        });
    }

    private void Toolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        toolbar.setTitle("");
        //setSupportActionBar(toolbar);
    }


    private void navigation() {

        drawerToggle = new ActionBarDrawerToggle(
                this, mdrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mdrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.profile:
                Intent profile = new Intent(MainActivity.this, MyProfile.class);
                startActivity(profile);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.appointment:
                Intent appoint = new Intent(MainActivity.this, My_Appointment.class);
                startActivity(appoint);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.contact_us:
                Intent contact_us = new Intent(MainActivity.this, Contact_Us.class);
                startActivity(contact_us);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.privacy_policy:
                Intent privacy = new Intent(MainActivity.this, Privacy_Policy.class);
                startActivity(privacy);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.logout:
                Intent logout = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(logout);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;
        }


        return true;
    }

}
