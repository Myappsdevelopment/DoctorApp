package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyAccount extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout lyt_account, notification, change_pass, pool_setting, shipping_loc, settings, about, contact, sign_out;
    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    private void init() {
        lyt_account = findViewById(R.id.lyt_account);
        lyt_account.setOnClickListener(this);

        back_arrow=findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        notification = findViewById(R.id.lyt_notification);
        notification.setOnClickListener(this);

        change_pass = findViewById(R.id.lyt_change_pass);
        change_pass.setOnClickListener(this);

        pool_setting = findViewById(R.id.lyt_pool_setting);
        pool_setting.setOnClickListener(this);

        shipping_loc = findViewById(R.id.lyt_shipping);
        shipping_loc.setOnClickListener(this);

        settings = findViewById(R.id.lyt_settings);
        settings.setOnClickListener(this);

        about = findViewById(R.id.lyt_about);
        about.setOnClickListener(this);

        contact = findViewById(R.id.lyt_contact);
        contact.setOnClickListener(this);

        sign_out = findViewById(R.id.lyt_signout);
        sign_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_account:
                Intent in1 = new Intent(this, Profile.class);
                startActivity(in1);

                break;

            case R.id.lyt_notification:
                Intent in2 = new Intent(this, Notification.class);
                startActivity(in2);
                break;

            case R.id.lyt_change_pass:
                Intent in3 = new Intent(this, Change_Password.class);
                startActivity(in3);

                break;

            case R.id.lyt_pool_setting:

                Intent in4 = new Intent(this, Pool_Settings.class);
                startActivity(in4);

                break;

            case R.id.lyt_shipping:
                Intent in5 = new Intent(this, Dashboard_Settings.class);
                startActivity(in5);

                break;

            case R.id.lyt_settings:

                Intent in6 = new Intent(this, Settings.class);
                startActivity(in6);
                break;

            case R.id.lyt_about:

                break;

            case R.id.lyt_contact:

                break;

            case R.id.lyt_signout:

                break;

        }
    }
}
