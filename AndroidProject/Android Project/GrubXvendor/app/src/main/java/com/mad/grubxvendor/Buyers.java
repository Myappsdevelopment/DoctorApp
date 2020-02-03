package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubxvendor.Tabs.Buyerstab;
import com.mad.grubxvendor.Tabs.Top_Buyers;

public class Buyers extends Fragment {

    TabLayout tab1;
    ViewPager viewPager;

    View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_buyers, container, false);

        init();
        return view;
    }


    private void init() {
        tab1 = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);


        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new Buyerstab(), "Buyers");
        viewPagerAdapter.addFragments(new Top_Buyers(), "Top Buyers");

        viewPager.setAdapter(viewPagerAdapter);
        tab1.setupWithViewPager(viewPager);




    }
}
