package com.mad.doctor_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mad.doctor_app.R;

public class Book_Appointment extends AppCompatActivity {

    Button btn_book;

    ImageView left_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__appointment);

        init();
    }

    private void init() {
        btn_book = findViewById(R.id.btn_book);
        left_arrow = findViewById(R.id.left_arrow_book_apt);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Book_Appointment.this, Payment_Gateway.class);
                startActivity(in);
            }
        });
    }
}
