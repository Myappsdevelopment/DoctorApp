package com.mad.grubxvendor.Tabs;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubxvendor.AddProduct;
import com.mad.grubxvendor.Model.DataModel_Buyers;
import com.mad.grubxvendor.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Top_Buyers extends Fragment {

    View view;
    GridView recycler_buyers;
    private List<DataModel_Buyers> datamodel;

    LoadGridDataAdapter loadGridDataAdapter;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_top__buyers, container, false);


        init();

        datamodel = new ArrayList<>();

        Data();

        loadGridDataAdapter = new LoadGridDataAdapter(getContext(), R.layout.item_view, datamodel);
        recycler_buyers.setAdapter(loadGridDataAdapter);


        return view;
    }


    private void init() {

        recycler_buyers = view.findViewById(R.id.grid_topbuyers);
    }

    private void Data() {

        DataModel_Buyers data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Sky Divine", "Wine Mart", "New");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "New");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

        data = new DataModel_Buyers(R.drawable.img3, "Jorathan", "Real Mart", "Active");
        datamodel.add(data);

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
                    Intent in = new Intent(context, AddProduct.class);
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
