package com.mad.grubxvendor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button login, request_otp;
    TextView register, forgot_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        login = findViewById(R.id.btn_login);
        request_otp = findViewById(R.id.requestotp_btn);
        register = findViewById(R.id.txt_register);
        forgot_pass = findViewById(R.id.forgot_pass);

        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, Forgot_password.class);
                finish();
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, MainActivity.class);
                finish();
                startActivity(in);
            }
        });

        request_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, OTP.class);
                finish();
                startActivity(in);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, Registration.class);
                finish();
                startActivity(in);
            }
        });
    }
}
