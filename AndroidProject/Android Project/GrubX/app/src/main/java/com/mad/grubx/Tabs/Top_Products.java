package com.mad.grubx.Tabs;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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
import com.mad.grubx.Product_Details;
import com.mad.grubx.R;
import com.mad.grubx.VendorDetails;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Top_Products extends Fragment {

    View view;

    GridView grid_products;

    private ArrayList<DataModel> datamodel;

    ProductsListAdapter productsListAdapter;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_top__products, container, false);

        init();

        datamodel = new ArrayList<>();



        datamodel.add(new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320"));
        datamodel.add(new DataModel(R.drawable.img2, "New", "Iced Tea, Brisk", "150", "160"));
        datamodel.add(new DataModel(R.drawable.img2, "New", "Iced Tea, Brisk", "150", "160"));
        datamodel.add(new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320"));
        datamodel.add(new DataModel(R.drawable.img3, "30%", "Cidre Apple", "300", "320"));

        productsListAdapter = new ProductsListAdapter(getContext(), R.layout.item_view, datamodel);
        grid_products.setAdapter(productsListAdapter);


        return view;
    }


    private void init() {
        grid_products = view.findViewById(R.id.grid_topproducts);
    }

    private static class ProductsListAdapter extends ArrayAdapter<DataModel> {
        Context context;
        int layoutResourceId;
        ArrayList<DataModel> data = new ArrayList<DataModel>();

        public ProductsListAdapter(Context product, int item_view, ArrayList<DataModel> datamodel) {
            super(product,item_view,datamodel);

            this.context = product;
            this.layoutResourceId = item_view;
            this.data = datamodel;
        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ProductsListAdapter.RecordHolder holder = null;


            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);




                holder = new ProductsListAdapter.RecordHolder();


                holder.discount = row.findViewById(R.id.discount);
                holder.amount = row.findViewById(R.id.amount);
                holder.disc_amount = row.findViewById(R.id.discount_amount);
                holder. img = row.findViewById(R.id.img);
                holder.crd = row.findViewById(R.id.cardview);

                row.setTag(holder);
            } else {
                holder = (ProductsListAdapter.RecordHolder) row.getTag();
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
                    Intent in = new Intent(context, Bevarages.class);
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
