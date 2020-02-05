package com.mad.doctor_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mad.doctor_app.R;

public class Hosital_Details_Activity extends AppCompatActivity {

    Button btn_appointment;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosital__details_);

        init();
    }

    private void init() {
        btn_appointment = findViewById(R.id.btn_book_appointment);
        back_arrow = findViewById(R.id.back_arrow_details);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Hosital_Details_Activity.this, Request_Token_Activity.class);
                startActivity(in);
            }
        });
    }
}
