package com.mad.grubx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Profile extends Fragment implements View.OnClickListener {
    RelativeLayout lyt_account, notification, change_pass, pool_setting, shipping_loc, settings, about, contact, sign_out;
    View view;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_profile, container, false);

        init();
        return view;
    }

    private void init() {
        lyt_account = view.findViewById(R.id.lyt_account);
        lyt_account.setOnClickListener(this);

        notification = view.findViewById(R.id.lyt_notification);
        notification.setOnClickListener(this);

        change_pass = view.findViewById(R.id.lyt_change_pass);
        change_pass.setOnClickListener(this);

        pool_setting = view.findViewById(R.id.lyt_pool_setting);
        pool_setting.setOnClickListener(this);

        shipping_loc = view.findViewById(R.id.lyt_shipping);
        shipping_loc.setOnClickListener(this);

        settings = view.findViewById(R.id.lyt_settings);
        settings.setOnClickListener(this);

        about = view.findViewById(R.id.lyt_about);
        about.setOnClickListener(this);

        contact = view.findViewById(R.id.lyt_contact);
        contact.setOnClickListener(this);

        sign_out = view.findViewById(R.id.lyt_signout);
        sign_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_account:
                Intent in1 = new Intent(getContext(), My_Account.class);
                startActivity(in1);

                break;

            case R.id.lyt_notification:
                Intent in2 = new Intent(getContext(), Notification.class);
                startActivity(in2);
                break;

            case R.id.lyt_change_pass:
                Intent in3 = new Intent(getContext(), Change_Password.class);
                startActivity(in3);

                break;

            case R.id.lyt_pool_setting:


                break;

            case R.id.lyt_shipping:
                Intent in5 = new Intent(getContext(), Shipping_Locations.class);
                startActivity(in5);

                break;

            case R.id.lyt_settings:

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
