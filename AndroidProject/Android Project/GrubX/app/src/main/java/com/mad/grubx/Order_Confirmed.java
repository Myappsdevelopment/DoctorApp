package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Order_Confirmed extends AppCompatActivity {
    Button btn_viewmore_products;
    TextView more_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__confirmed);

        btn_viewmore_products = findViewById(R.id.btn_moreproducts);
        more_history = findViewById(R.id.view_orders);
        more_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Order_Confirmed.this, MyOrders.class);
                startActivity(in);
            }
        });
    }
}
