package com.mad.grubxvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddProduct extends AppCompatActivity implements View.OnClickListener {
    TextView saveasnew, save;
    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        init();
    }

    private void init() {
        saveasnew = findViewById(R.id.save_new);
        saveasnew.setOnClickListener(this);
        save = findViewById(R.id.save);
        save.setOnClickListener(this);

        back_arrow=findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_new:
                Intent in = new Intent(AddProduct.this, Products.class);
                finish();
                startActivity(in);
                break;

            case R.id.save:
                Intent in1 = new Intent(AddProduct.this, Products.class);
                finish();
                startActivity(in1);
                break;
        }
    }
}
