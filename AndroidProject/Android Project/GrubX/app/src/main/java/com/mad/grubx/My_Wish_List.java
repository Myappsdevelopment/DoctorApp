package com.mad.grubx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubx.Model.DataModel;

import java.util.ArrayList;

public class My_Wish_List extends AppCompatActivity {
    GridView grid_wishlist;

    ArrayList<DataModel> arrayList = new ArrayList<>();
    LoadGridDataAdapter loadGridDataAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__wish__list);

        init();


        arrayList.add(new DataModel(R.drawable.img3, "5%", "Cidre, Apple", "180", "200"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Iced, Tea", "280", "300"));
        arrayList.add(new DataModel(R.drawable.img3, "5%", "Iced, Tea", "450", "500"));
        arrayList.add(new DataModel(R.drawable.img2, "NEW", "Cidre, Apple", "200", "220"));
        arrayList.add(new DataModel(R.drawable.img3, "NEW", "Iced, Tea", "700", "600"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Cidre, Apple", "999", "1100"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Cidre, Apple", "980", "1200"));

        loadGridDataAdapter = new LoadGridDataAdapter(My_Wish_List.this, R.layout.item_view, arrayList);
        grid_wishlist.setAdapter(loadGridDataAdapter);
    }

    private void init() {
        grid_wishlist = findViewById(R.id.grid_wishlist);

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
        ArrayList<DataModel> data = new ArrayList<DataModel>();


        public LoadGridDataAdapter(Context context1, int layoutResourceId1, ArrayList<DataModel> data1) {
            super(context1, layoutResourceId1, data1);
            this.layoutResourceId = layoutResourceId1;
            this.context = context1;
            this.data = data1;
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
                holder.discount = row.findViewById(R.id.discount);
                holder.amount = row.findViewById(R.id.amount);
                holder.disc_amount = row.findViewById(R.id.discount_amount);
                holder.crd = row.findViewById(R.id.cardview);
                holder.img = row.findViewById(R.id.img);
                holder.prd_name = row.findViewById(R.id.prd_name);
                row.setTag(holder);
            } else {
                holder = (LoadGridDataAdapter.RecordHolder) row.getTag();
            }

            DataModel item = data.get(position);
            holder.discount.setText(item.getDiscount());
            holder.prd_name.setText(item.getPrd_name());
            holder.amount.setText(item.getPrd_amount());
            holder.disc_amount.setText(item.getPrd_strikeamount());
            holder.img.setImageResource(item.getImage());

            holder.disc_amount.setPaintFlags(holder.disc_amount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(context, Product_Details.class);
                    context.startActivity(in);
                }
            });


            return row;

        }

        static class RecordHolder {
            TextView discount, amount, disc_amount, prd_name;
            ImageView img;
            CardView crd;

        }
    }
}
