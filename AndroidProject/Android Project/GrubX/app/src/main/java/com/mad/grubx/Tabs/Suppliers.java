package com.mad.grubx.Tabs;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.mad.grubx.Bevarages;
import com.mad.grubx.Model.DataModel;
import com.mad.grubx.Model.DataModel1;
import com.mad.grubx.Model.Item;
import com.mad.grubx.Product_categories;
import com.mad.grubx.R;
import com.mad.grubx.VendorDetails;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Suppliers extends Fragment {

    View view;

    GridView supplier_grid;

    private ArrayList<DataModel1> datamodel;
    SupplierListAdapter supplierListAdapter;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_suppliers, container, false);

        init();

        datamodel = new ArrayList<>();


        datamodel.add(new DataModel1(R.drawable.img4, "30", "Alex Lean"));
        datamodel.add(new DataModel1(R.drawable.img5, "20", "AMX Goods"));
        datamodel.add(new DataModel1(R.drawable.img4, "25", "AMX Goods"));
        datamodel.add(new DataModel1(R.drawable.img5, "3", "Alex Lean"));
        datamodel.add(new DataModel1(R.drawable.img5, "2", "Alex Lean"));

        supplierListAdapter = new SupplierListAdapter(getContext(), R.layout.item_view1, datamodel);
        supplier_grid.setAdapter(supplierListAdapter);


        return view;
    }


    private void init() {
        supplier_grid = view.findViewById(R.id.grid_suppliers);
    }


    private static class SupplierListAdapter extends ArrayAdapter<DataModel1> {
        Context context;
        int layoutResourceId;
        ArrayList<DataModel1> data = new ArrayList<DataModel1>();

        public SupplierListAdapter(Context suppliers, int category_gridview_item, ArrayList<DataModel1> datamodel) {
            super(suppliers, category_gridview_item, datamodel);
            this.context = suppliers;
            this.layoutResourceId = category_gridview_item;
            this.data = datamodel;
        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            SupplierListAdapter.RecordHolder holder = null;


            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new SupplierListAdapter.RecordHolder();
                holder.prd_name = row.findViewById(R.id.name);
                holder.prdcnt = row.findViewById(R.id.prd_cnt);
                holder.img = row.findViewById(R.id.img);
                holder.grid_item = row.findViewById(R.id.cardview);
                row.setTag(holder);
            } else {
                holder = (SupplierListAdapter.RecordHolder) row.getTag();
            }

            DataModel1 item = data.get(position);
            holder.prd_name.setText(item.getPrd_name());
            holder.prdcnt.setText(item.getProducts_cnt());
            holder.img.setImageResource(item.getImage());

            holder.grid_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(context, Bevarages.class);
                    context.startActivity(in);
                }
            });


            return row;

        }

        static class RecordHolder {
            TextView prd_name, prdcnt;
            ImageView img;
            CardView grid_item;

        }
    }


}
