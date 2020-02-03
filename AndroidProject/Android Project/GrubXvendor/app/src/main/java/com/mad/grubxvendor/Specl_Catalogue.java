package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Specl_Catalogue extends AppCompatActivity {
    CardView baked_goods, meat_poultry, bevarages, grocery, fruits, takeout;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specl__catalogue);

        init();
    }

    private void init() {
        baked_goods = findViewById(R.id.crd_baked);
        meat_poultry = findViewById(R.id.crd_meat);
        bevarages = findViewById(R.id.crd_bevarages);
        grocery = findViewById(R.id.crd_grocery);
        fruits = findViewById(R.id.crd_fruits);
        takeout = findViewById(R.id.crd_takeout);

        back_arrow = findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        bevarages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Specl_Catalogue.this, Bevarages.class);
                startActivity(in);
            }
        });
    }
}
