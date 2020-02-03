package com.mad.grubx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mad.grubx.Tabs.All;
import com.mad.grubx.Tabs.Completed;
import com.mad.grubx.Tabs.Due;
import com.mad.grubx.Tabs.Paid;
import com.mad.grubx.Tabs.Pending;

public class Invoice extends Fragment {

    TabLayout tab;
    ViewPager viewPager;
    View view;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_invoice, container, false);

        init();
        return view;
    }


    private void init() {
        tab=view.findViewById(R.id.tablayout_invoice);
        viewPager=view.findViewById(R.id.viewpager_invoice);

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new All(), "All");
        viewPagerAdapter.addFragments(new Paid(), "Paid");
        viewPagerAdapter.addFragments(new Due(), "Due");
        viewPager.setAdapter(viewPagerAdapter);
        tab.setupWithViewPager(viewPager);
    }
}
