package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgot_password extends AppCompatActivity {

    Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btn_reset = findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Forgot_password.this, OTPEntry.class);
                finish();
                startActivity(in);
            }
        });
    }
}
