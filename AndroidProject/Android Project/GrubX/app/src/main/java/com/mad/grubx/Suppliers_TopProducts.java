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
import com.mad.grubx.Tabs.Due;
import com.mad.grubx.Tabs.Paid;
import com.mad.grubx.Tabs.Suppliers;
import com.mad.grubx.Tabs.Top_Products;

public class Suppliers_TopProducts extends Fragment {
    TabLayout tab;
    ViewPager viewPager;
    View view;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_suppliers__top_products, container, false);

        init();
        return view;
    }


    private void init() {
        tab=view.findViewById(R.id.tablayout_suppliers);
        viewPager=view.findViewById(R.id.viewpager_suppliers);

        multiViewAdapter viewPagerAdapter = new multiViewAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new Suppliers(), "SUPPLIERS");
        viewPagerAdapter.addFragments(new Top_Products(), "TOP PRODUCTS");
        viewPager.setAdapter(viewPagerAdapter);
        tab.setupWithViewPager(viewPager);
    }
}
