package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubxvendor.Tabs.Completed;
import com.mad.grubxvendor.Tabs.Messages;
import com.mad.grubxvendor.Tabs.Notifications;
import com.mad.grubxvendor.Tabs.Pending;
import com.mad.grubxvendor.Tabs.PoolOrder;
import com.mad.grubxvendor.Tabs.Upcoming;

public class Notification extends AppCompatActivity {

    TabLayout tab1;
    ViewPager viewPager;
    ImageView back_arrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);

        tab1 = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        back_arrow=findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Messages(), "Messages");
        viewPagerAdapter.addFragments(new Notifications(), "Notifications");
        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);
    }
}
