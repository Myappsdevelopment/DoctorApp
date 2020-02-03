package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubx.Tabs.Completed;
import com.mad.grubx.Tabs.My_cart;
import com.mad.grubx.Tabs.Pending;
import com.mad.grubx.Tabs.Pool_Cart;

public class MyCart extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        init();

    }

    private void init() {
        viewPager=findViewById(R.id.viewpager_mycart);
        tab=findViewById(R.id.tab_cart);


        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new My_cart(), "My cart");
        viewPagerAdapter.addFragments(new Pool_Cart(), "Pool cart");
        viewPager.setAdapter(viewPagerAdapter);
        tab.setupWithViewPager(viewPager);
    }
}
