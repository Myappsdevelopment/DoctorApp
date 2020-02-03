package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubxvendor.Tabs.Completed;
import com.mad.grubxvendor.Tabs.Pending;
import com.mad.grubxvendor.Tabs.Pending1;
import com.mad.grubxvendor.Tabs.PoolOrder;
import com.mad.grubxvendor.Tabs.Received;
import com.mad.grubxvendor.Tabs.Upcoming;

public class Pending_Received extends Fragment {

    TabLayout tab1;
    ViewPager viewPager;

    View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_pending__received, container, false);

        init();
        return view;
    }

    private void init() {
        tab1 = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);


        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new Pending1(), "Pending");
        viewPagerAdapter.addFragments(new Received(), "Received");

        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);


    }

}
