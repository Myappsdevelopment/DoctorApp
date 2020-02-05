package com.mad.doctor_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mad.doctor_app.R;

public class Payment_Gateway extends AppCompatActivity {

    Button btn_paynow;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__gateway);

        init();
    }

    private void init() {

        btn_paynow = findViewById(R.id.btn_paynow);
        img_back = findViewById(R.id.back_arrow_payment);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Payment_Gateway.this, Booking_Success.class);
                startActivity(in);
            }
        });
    }
}
