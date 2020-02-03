package com.mad.grubx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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

import com.mad.grubx.Model.Item;

import java.util.ArrayList;

public class Product_category_fragment extends Fragment {

    GridView category_grid;
    View view;

    ArrayList<Item> arrayList = new ArrayList<>();
    LoadGridDataAdapter loadGridDataAdapter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_product_category_fragment, container, false);

        init();


        arrayList.add(new Item(R.drawable.category1, "Baked Goods,Sweets", "1245"));
        arrayList.add(new Item(R.drawable.category2, "Meat & Poultry", "11"));
        arrayList.add(new Item(R.drawable.category3, "Beverage & Drinks", "245"));
        arrayList.add(new Item(R.drawable.category4, "Food", "859"));
        arrayList.add(new Item(R.drawable.category5, "Restaurant Supplies ", "45"));
        arrayList.add(new Item(R.drawable.category6, "Sea Food", "259"));
        arrayList.add(new Item(R.drawable.category7, "Cleaning Supplies", "15"));

        loadGridDataAdapter = new LoadGridDataAdapter(getContext(), R.layout.category_gridview_item, arrayList);
        category_grid.setAdapter(loadGridDataAdapter);
        return view;
    }


    private void init() {
        category_grid = view.findViewById(R.id.category_gridview);

    }

    private static class LoadGridDataAdapter extends ArrayAdapter<Item> {
        Context context;
        int layoutResourceId;
        ArrayList<Item> data = new ArrayList<Item>();

        public LoadGridDataAdapter(Context context, int layoutResourceId,
                                   ArrayList<Item> data) {
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
                holder.prd_name = row.findViewById(R.id.category_name);
                holder.prdcnt = row.findViewById(R.id.category_cnt);
                holder.img = row.findViewById(R.id.img_grid);
                holder.grid_item = row.findViewById(R.id.card);
                row.setTag(holder);
            } else {
                holder = (RecordHolder) row.getTag();
            }

            Item item = data.get(position);
            holder.prd_name.setText(item.getName());
            holder.prdcnt.setText(item.getPrd_count());
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
