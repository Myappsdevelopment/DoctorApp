package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Switch_Business extends AppCompatActivity {

    FloatingActionButton fab;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch__business);

        init();
    }

    private void init() {
        fab = findViewById(R.id.fab_addbusiness);

        back_arrow=findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Switch_Business.this, Add_Business.class);
                startActivity(in);

            }
        });
    }
}
