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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubxvendor.Model.DataModel_Buyers;
import com.mad.grubxvendor.Tabs.Buyerstab;

import java.util.ArrayList;
import java.util.List;

public class My_Favourite extends AppCompatActivity {

    GridView recycler_buyers;
    private List<DataModel_Buyers> datamodel;

    LoadGridDataAdapter loadGridDataAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__favourite);


        init();

        datamodel = new ArrayList<>();

        Data();

        loadGridDataAdapter = new LoadGridDataAdapter(My_Favourite.this, R.layout.item_view, datamodel);
        recycler_buyers.setAdapter(loadGridDataAdapter);


    }

    private void init() {

        recycler_buyers = findViewById(R.id.grid_my_favourites);

        back_arrow=findViewById(R.id.back);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void Data() {

        DataModel_Buyers data = new DataModel_Buyers(R.drawable.person, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.person, "Sky Divine", "Wine Mart", "New");
        datamodel.add(data);

        /*data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "New");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);*/

    }


    private static class LoadGridDataAdapter extends ArrayAdapter<DataModel_Buyers> {
        Context context;
        int layoutResourceId;
        List<DataModel_Buyers> data = new ArrayList<>();


        public LoadGridDataAdapter(Context context1, int category_gridview_item, List<DataModel_Buyers> datamodel) {
            super(context1, category_gridview_item, datamodel);
            this.layoutResourceId = category_gridview_item;
            this.context = context1;
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
                holder.status = row.findViewById(R.id.status);
                holder.name = row.findViewById(R.id.buyer_name);
                holder.mart_name = row.findViewById(R.id.mart_name);
                holder.img = row.findViewById(R.id.img);
                holder.crd = row.findViewById(R.id.cardview);
                holder.contact = row.findViewById(R.id.contact);
                row.setTag(holder);
            } else {
                holder = (LoadGridDataAdapter.RecordHolder) row.getTag();
            }

            DataModel_Buyers item = data.get(position);
            holder.status.setText(item.getStatus());
            holder.name.setText(item.getName());
            holder.mart_name.setText(item.getMart_name());
            holder.img.setImageResource(item.getImg());


            holder.contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(context, Buyer_Details.class);
                    context.startActivity(in);
                }
            });


            return row;

        }

        static class RecordHolder {
            TextView status, name, mart_name, contact;
            ImageView img;
            CardView crd;

        }
    }
}
