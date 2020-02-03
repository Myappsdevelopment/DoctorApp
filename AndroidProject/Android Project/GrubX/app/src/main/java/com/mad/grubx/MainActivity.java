package com.mad.grubx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    TabLayout tab1, tab2;
    ViewPager viewPager, viewPager1;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle drawerToggle;
    private DrawerLayout mdrawerLayout;
    FloatingActionButton fab;
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
        // tab1 = findViewById(R.id.tablayout);
        //tab2 = findViewById(R.id.tablayout1);
        //viewPager = findViewById(R.id.viewpager);
        //viewPager1 = findViewById(R.id.viewpager1);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        fab = findViewById(R.id.main_fab);
        toolbar = findViewById(R.id.mainToolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


       /* multiViewAdapter viewPagerAdapter = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Pending(), "Pending");
        viewPagerAdapter.addFragments(new Completed(), "Completed");
        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);


        multiViewAdapter viewPagerAdapter1 = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter1.addFragments(new Trending(), "Trending");
        viewPagerAdapter1.addFragments(new TopDeals(), "Top Deals");
        viewPagerAdapter1.addFragments(new Featured(), "Featured");
        viewPager1.setAdapter(viewPagerAdapter1);
        tab2.setupWithViewPager(viewPager1);*/


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, MyCart.class);
                startActivity(in);
            }
        });


    }

    private void navigation() {

        drawerToggle = new ActionBarDrawerToggle(
                this, mdrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mdrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


    }

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


    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            //Bottom Navigation items
            case R.id.navigation_home:

                loadFragment(new Product_category_fragment());

                /*Intent in = new Intent(getApplicationContext(), Product_categories.class);
                startActivity(in);*/
                break;

            case R.id.navigation_file:
                loadFragment(new Invoice());

               /* Intent in1 = new Intent(getApplicationContext(), Invoice.class);
                startActivity(in1);*/
                break;

            case R.id.navigation:

                loadFragment(new HomeActivity());
               /* Intent in2 = new Intent(getApplicationContext(), Invoice.class);
                startActivity(in2);*/
                break;

            case R.id.navigation_prd:

                loadFragment(new Suppliers_TopProducts());

                /*Intent in3 = new Intent(getApplicationContext(), Suppliers_TopProducts.class);
                startActivity(in3);*/
                break;

            case R.id.profile:

                loadFragment(new Profile());

               /* Intent in4 = new Intent(getApplicationContext(), Profile.class);
                startActivity(in4);*/
                break;

            //Side Navigation Items
            case R.id.home:
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.categories:
                Intent in5 = new Intent(getApplicationContext(), Product_categories.class);
                startActivity(in5);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.orders:
                Intent in6 = new Intent(getApplicationContext(), MyOrders.class);
                startActivity(in6);

                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.wish_list:
                Intent in7 = new Intent(getApplicationContext(), My_Wish_List.class);
                startActivity(in7);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.add_business:
                Intent in8 = new Intent(getApplicationContext(), Add_Business.class);
                startActivity(in8);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.switch_business:
                Intent in9 = new Intent(getApplicationContext(), Switch_Business.class);
                startActivity(in9);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.reward:
                Intent in10 = new Intent(getApplicationContext(), Rewards.class);
                startActivity(in10);
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.about_us:
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.invite:
                mdrawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.rate_us:
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
}
