package com.mad.grubx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btn_login, btn_request_otp;
    TextView btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_register = findViewById(R.id.create_an_account);
        btn_register.setOnClickListener(this);
        btn_request_otp = findViewById(R.id.requestotp_btn);
        btn_request_otp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Intent in = new Intent(Login.this, MainActivity.class);
                finish();
                startActivity(in);
                break;

            case R.id.create_an_account:
                Intent in1 = new Intent(Login.this, Registration.class);
                finish();
                startActivity(in1);
                break;

            case R.id.requestotp_btn:
                Intent in2 = new Intent(Login.this, OTP.class);
                finish();
                startActivity(in2);
                break;
        }
    }
}
