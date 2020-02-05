package com.mad.doctor_app.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.doctor_app.Adapter.LoadGridDataAdapter;
import com.mad.doctor_app.R;

import java.util.ArrayList;

public class Request_Token_Activity extends AppCompatActivity {

    GridView grid_token;
    ArrayList<Item_token> arrayList = new ArrayList<>();
    LoadNumbersAdapter loadNumbersAdapter;
    Button btn_requesttkn;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request__token_);

        init();

        for (int i = 1; i <= 150; i++) {
            arrayList.add(new Item_token(i));
        }


        loadNumbersAdapter = new LoadNumbersAdapter(this, R.layout.list_item_tokens, arrayList);
        grid_token.setAdapter(loadNumbersAdapter);
    }

    private void init() {

        grid_token = findViewById(R.id.grid_token);
        btn_requesttkn = findViewById(R.id.btn_reqsttokn);
        back_arrow = findViewById(R.id.back_arrow_token);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_requesttkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Request_Token_Activity.this, Book_Appointment.class);
                startActivity(in);
            }
        });

        grid_token.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                TextView clickedItem = v.findViewById(R.id.btn_number);
                clickedItem.setBackgroundColor(R.color.green);



               /* int color = Color.parseColor("#4db874");
                Drawable background = v.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();*/


               /* ColorDrawable listViewColor = (ColorDrawable) v.getBackground();

                int colorId = listViewColor.getColor();


                //int viewColor = ((ColorDrawable) v.getBackground()).getColor();


                if (colorId == R.color.white) {
                    clickedItem.setBackgroundColor(R.color.green);
                } else {
                    clickedItem.setBackgroundColor(R.color.white);
                }*/


            }
        });
    }


}
