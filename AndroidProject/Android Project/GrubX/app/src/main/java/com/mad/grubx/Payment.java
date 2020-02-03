package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Payment extends AppCompatActivity {
    LinearLayout lyt_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        lyt_pay=findViewById(R.id.lyt_pay);

        lyt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Payment.this,Order_Confirmed.class);
                startActivity(in);
            }
        });
    }
}
