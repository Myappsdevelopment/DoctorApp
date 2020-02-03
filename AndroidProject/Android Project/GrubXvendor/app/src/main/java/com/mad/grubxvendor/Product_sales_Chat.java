package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Product_sales_Chat extends Fragment {

    View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_product_sales__chat, container, false);

        init();
        return view;
    }

    private void init() {
    }
}
