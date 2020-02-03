package com.mad.grubx;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubx.Tabs.Completed;
import com.mad.grubx.Tabs.Featured;
import com.mad.grubx.Tabs.Pending;
import com.mad.grubx.Tabs.TopDeals;
import com.mad.grubx.Tabs.Trending;

public class HomeActivity extends Fragment {
    View view;

    TabLayout tab1, tab2;
    ViewPager viewPager, viewPager1;


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
        tab2 = view.findViewById(R.id.tablayout1);
        viewPager1 = view.findViewById(R.id.viewpager1);

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new Pending(), "Pending");
        viewPagerAdapter.addFragments(new Completed(), "Completed");
        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);


        multiViewAdapter viewPagerAdapter1 = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter1.addFragments(new Trending(), "Trending");
        viewPagerAdapter1.addFragments(new TopDeals(), "Top Deals");
        viewPagerAdapter1.addFragments(new Featured(), "Featured");
        viewPager1.setAdapter(viewPagerAdapter1);
        tab2.setupWithViewPager(viewPager1);


    }

}
