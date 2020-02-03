package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubx.Tabs.Completed;
import com.mad.grubx.Tabs.OnGoing;
import com.mad.grubx.Tabs.Past_Orders;
import com.mad.grubx.Tabs.Pending;
import com.mad.grubx.Tabs.Pool_Orders;

public class MyOrders extends AppCompatActivity {

    TabLayout myorders_tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        init();
    }

    private void init() {

        myorders_tab = findViewById(R.id.tablayout_myorders);
        viewPager = findViewById(R.id.viewpager_myorders);

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new OnGoing(), "OnGoing");
        viewPagerAdapter.addFragments(new Pool_Orders(), "Pool Orders");
        viewPagerAdapter.addFragments(new Past_Orders(), "Past Orders");
        viewPager.setAdapter(viewPagerAdapter);
        myorders_tab.setupWithViewPager(viewPager);


    }
}
