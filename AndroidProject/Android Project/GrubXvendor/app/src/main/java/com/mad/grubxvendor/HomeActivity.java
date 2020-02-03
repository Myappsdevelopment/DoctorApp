package com.mad.grubxvendor;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubxvendor.Tabs.Completed;
import com.mad.grubxvendor.Tabs.Pending;
import com.mad.grubxvendor.Tabs.PoolOrder;
import com.mad.grubxvendor.Tabs.Upcoming;

import java.util.ArrayList;

public class HomeActivity extends Fragment {
    View view;

    TabLayout tab1;
    ViewPager viewPager;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_home, container, false);

        init();
        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init() {
        tab1 = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new Pending(), "Pending");
        viewPagerAdapter.addFragments(new Upcoming(), "Upcoming");
        viewPagerAdapter.addFragments(new Completed(), "Completed");
        viewPagerAdapter.addFragments(new PoolOrder(), "Pool Order");
        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);

    }

}
