package com.mad.grubxvendor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Sepcial_Catalogue extends Fragment implements View.OnClickListener {

    CardView crd_bevarages;
    View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_sepcial__catalogue, container, false);

        init();
        return view;
    }


    private void init() {
        crd_bevarages = view.findViewById(R.id.crd_bevarages);
        crd_bevarages.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.crd_bevarages:

                Intent in = new Intent(getContext(), Bevarages.class);
                startActivity(in);
                break;

        }
    }
}



