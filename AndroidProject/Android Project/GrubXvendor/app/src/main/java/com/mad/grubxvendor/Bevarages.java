package com.mad.grubxvendor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mad.grubxvendor.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class Bevarages extends AppCompatActivity {

    GridView gridView;

    private List<DataModel> datamodel;
    LoadGridDataAdapter loadGridDataAdapter;
    ImageView back_arrow;

    FloatingActionButton add_prd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevarages);

        init();

        datamodel = new ArrayList<>();

        Data();

        loadGridDataAdapter = new LoadGridDataAdapter(this, R.layout.category_gridview_item, datamodel);
        gridView.setAdapter(loadGridDataAdapter);

        add_prd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Bevarages.this, AddProduct.class);
                startActivity(in);
            }
        });
    }


    private void Data() {

        DataModel data = new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320");
        datamodel.add(data);

        data = new DataModel(R.drawable.img2, "New", "Iced Tea, Brisk", "150", "160");
        datamodel.add(data);

        data = new DataModel(R.drawable.img2, "New", "Iced Tea, Brisk", "150", "160");
        datamodel.add(data);

        data = new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320");
        datamodel.add(data);

        data = new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320");
        datamodel.add(data);

    }

    private void init() {
        gridView = findViewById(R.id.grid_bevarages);
        add_prd = findViewById(R.id.add_prd);

        back_arrow = findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


    private static class LoadGridDataAdapter extends ArrayAdapter<DataModel> {
        Context context;
        int layoutResourceId;
        List<DataModel> data = new ArrayList<>();

        public LoadGridDataAdapter(Bevarages context, int category_gridview_item, List<DataModel> datamodel) {
            super(context, category_gridview_item, datamodel);
            this.layoutResourceId = category_gridview_item;
            this.context = context;
            this.data = datamodel;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            LoadGridDataAdapter.RecordHolder holder = null;


            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new LoadGridDataAdapter.RecordHolder();
                holder.name = row.findViewById(R.id.prd_name);
                holder.amount = row.findViewById(R.id.amount);
                holder.disc_amount = row.findViewById(R.id.discount_amount);
                holder.img = row.findViewById(R.id.img_grid);
                holder.crd = row.findViewById(R.id.cardview);
                holder.btn_edit = row.findViewById(R.id.btn_edit);
                row.setTag(holder);
            } else {
                holder = (LoadGridDataAdapter.RecordHolder) row.getTag();
            }

            DataModel item = data.get(position);
            holder.name.setText(item.getPrd_name());
            holder.amount.setText(item.getPrd_amount());
            holder.disc_amount.setText(item.getPrd_strikeamount());
            holder.img.setImageResource(item.getImage());


            holder.btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(context, AddProduct.class);
                    context.startActivity(in);
                }
            });


            return row;

        }

        static class RecordHolder {
            TextView name, amount, disc_amount;
            ImageView img;
            Button btn_edit;
            CardView crd;

        }
    }
}
