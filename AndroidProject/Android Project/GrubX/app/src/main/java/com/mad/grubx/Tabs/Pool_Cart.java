package com.mad.grubx.Tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mad.grubx.Pool_Shopper;
import com.mad.grubx.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Pool_Cart extends Fragment {

    View view;
    TextView view_poolshopper;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pool__cart, container, false);

        view_poolshopper=view.findViewById(R.id.view_poolshopper);

        view_poolshopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getContext(), Pool_Shopper.class);
                startActivity(in);
            }
        });

        return view;
    }
}
