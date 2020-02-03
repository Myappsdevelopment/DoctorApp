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
import com.mad.grubx.Model.Item;

import java.util.ArrayList;

public class Bevarages extends AppCompatActivity {

    GridView gridView;

    ArrayList<DataModel> arrayList = new ArrayList<>();
    LoadGridDataAdapter loadGridDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevarages);

        init();

        arrayList.add(new DataModel(R.drawable.img3, "5%", "Cidre, Apple", "180", "200"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Iced, Tea", "280", "300"));
        arrayList.add(new DataModel(R.drawable.img3, "5%", "Iced, Tea", "450", "500"));
        arrayList.add(new DataModel(R.drawable.img2, "NEW", "Cidre, Apple", "200", "220"));
        arrayList.add(new DataModel(R.drawable.img3, "NEW", "Iced, Tea", "700", "600"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Cidre, Apple", "999", "1100"));
        arrayList.add(new DataModel(R.drawable.img2, "5%", "Cidre, Apple", "980", "1200"));

        loadGridDataAdapter = new LoadGridDataAdapter(this, R.layout.item_view, arrayList);
        gridView.setAdapter(loadGridDataAdapter);
    }

    private void init() {
        gridView = findViewById(R.id.grid_bevarages);
    }

    private static class LoadGridDataAdapter extends ArrayAdapter<DataModel> {
        Context context;
        int layoutResourceId;
        ArrayList<DataModel> data = new ArrayList<DataModel>();


        public LoadGridDataAdapter(Bevarages context, int layoutResourceId, ArrayList<DataModel> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RecordHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new RecordHolder();
                holder.discount = row.findViewById(R.id.discount);
                holder.amount = row.findViewById(R.id.amount);
                holder.disc_amount = row.findViewById(R.id.discount_amount);
                holder.crd = row.findViewById(R.id.cardview);
                holder.img = row.findViewById(R.id.img);
                row.setTag(holder);
            } else {
                holder = (LoadGridDataAdapter.RecordHolder) row.getTag();
            }

            DataModel item = data.get(position);
            holder.discount.setText(item.getDiscount());
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
            TextView discount, amount, disc_amount;
            ImageView img;
            CardView crd;

        }
    }
}
