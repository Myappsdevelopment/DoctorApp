package com.mad.doctor_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mad.doctor_app.R;

public class Registration_Activity extends AppCompatActivity {

    Button btn_register;
    TextView txt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);

        init();
    }

    private void init() {

        btn_register=findViewById(R.id.btn_register);
        txt_login=findViewById(R.id.txt_login);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Registration_Activity.this,Login_Activity.class);
                startActivity(in);
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Registration_Activity.this,Login_Activity.class);
                startActivity(in);
            }
        });
    }
}
