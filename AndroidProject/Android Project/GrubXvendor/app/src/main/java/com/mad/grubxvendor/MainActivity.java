package com.mad.grubxvendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.mad.grubxvendor.Tabs.Completed;
import com.mad.grubxvendor.Tabs.Pending;
import com.mad.grubxvendor.Tabs.PoolOrder;
import com.mad.grubxvendor.Tabs.Upcoming;

public class MainActivity extends FragmentActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    TabLayout tab1, tab2;
    ViewPager viewPager, viewPager1;
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle drawerToggle;
    private DrawerLayout mdrawerLayout;
    FrameLayout fragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        navigation();

        loadFragment(new HomeActivity());


    }


    private void init() {
        //tab1 = findViewById(R.id.tablayout);
        // viewPager = findViewById(R.id.viewpager);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        fragment = findViewById(R.id.framelayout);
        fab = findViewById(R.id.main_fab);
        toolbar = findViewById(R.id.mainToolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        /*multiViewAdapter viewPagerAdapter = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Pending(), "Pending");
        viewPagerAdapter.addFragments(new Upcoming(), "Upcoming");
        viewPagerAdapter.addFragments(new Completed(), "Completed");
        viewPagerAdapter.addFragments(new PoolOrder(), "Pool Order");
        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);*/


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, Notification.class);
                startActivity(in);
            }
        });


    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment;
        switch (menuItem.getItemId()) {

            //Bottom Navigation items
            case R.id.catalogue:

                loadFragment(new Sepcial_Catalogue());

                /*Intent catalogue = new Intent(getApplicationContext(), Sepcial_Catalogue.class);
                startActivity(catalogue);*/

                break;

            case R.id.pending_received:

                loadFragment(new Pending_Received());

                /*Intent pending = new Intent(getApplicationContext(), Pending_Received.class);
                startActivity(pending);*/
                break;

            case R.id.home:
                //fragment = new HomeActivity();

                /*fragment = new HomeActivity();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,fragment);
                fragmentTransaction.commit();*/

                loadFragment(new HomeActivity());


                break;

            case R.id.buyers:

                loadFragment(new Buyers());
                /*Intent buyers = new Intent(getApplicationContext(), Buyers.class);
                startActivity(buyers);*/

                break;

            case R.id.product_sales_chart:
                loadFragment(new Product_sales_Chat());

               /* Intent saleschat = new Intent(getApplicationContext(), Product_sales_Chat.class);
                startActivity(saleschat);*/
                break;

            //Side Navigation items

            case R.id.products:
                Intent Products = new Intent(getApplicationContext(), Products.class);
                startActivity(Products);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.add_products:

                Intent addProducts = new Intent(getApplicationContext(), AddProduct.class);
                startActivity(addProducts);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.business:

                Intent business = new Intent(getApplicationContext(), Business.class);
                startActivity(business);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;


            case R.id.add_business:

                Intent addbusiness = new Intent(getApplicationContext(), Add_Business.class);
                startActivity(addbusiness);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;


            case R.id.my_favourite:
                Intent favourite = new Intent(getApplicationContext(), My_Favourite.class);
                startActivity(favourite);
                mdrawerLayout.closeDrawer(Gravity.START);

                break;

            case R.id.my_account:

                Intent account = new Intent(getApplicationContext(), MyAccount.class);
                startActivity(account);
                mdrawerLayout.closeDrawer(Gravity.START);

                break;

            case R.id.spcl_catalogue:

                Intent splcatalogue = new Intent(getApplicationContext(), Specl_Catalogue.class);
                startActivity(splcatalogue);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.place_order:
                mdrawerLayout.closeDrawer(Gravity.START);

                break;

            case R.id.rate_us:
                mdrawerLayout.closeDrawer(Gravity.START);

                break;

            case R.id.about_us:
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.sign_out:

                Intent out = new Intent(MainActivity.this, Login.class);
                finish();
                startActivity(out);

                mdrawerLayout.closeDrawer(Gravity.START);

                break;

        }


        return true;
    }

    /*private void loadFragment(android.app.Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }*/


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    private void navigation() {

        drawerToggle = new ActionBarDrawerToggle(
                this, mdrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mdrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


    }


}
