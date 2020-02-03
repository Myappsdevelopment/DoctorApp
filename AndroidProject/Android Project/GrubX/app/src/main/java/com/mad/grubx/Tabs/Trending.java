package com.mad.grubx.Tabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mad.grubx.Model.DataModel;
import com.mad.grubx.Product_Details;
import com.mad.grubx.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Trending extends Fragment {
    View view;
    RecyclerView recyclerView;

    private List<DataModel> datamodel;


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trending, container, false);


        init();

        datamodel = new ArrayList<>();

        Data();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        TrendingListAdapter mAdapter = new TrendingListAdapter(getContext(), datamodel);
        recyclerView.setAdapter(mAdapter);


        return view;
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
        recyclerView = view.findViewById(R.id.recycler_trending);
    }

    private class TrendingListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<DataModel> data1;

        public TrendingListAdapter(Context context, List<DataModel> datamodel) {
            this.context = context;
            this.data1 = datamodel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final DataModel data = data1.get(position);

            holder.discount.setText(data.getDiscount());
            holder.amount.setText(data.getPrd_amount());
            holder.prd_name.setText(data.getPrd_name());
            holder.disc_amount.setText(data.getPrd_strikeamount());
            holder.img.setImageResource(data.getImage());


            holder.disc_amount.setPaintFlags(holder.disc_amount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getContext(), Product_Details.class);
                    startActivity(in);
                }
            });


        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView discount, amount, disc_amount, prd_name;
        ImageView img;
        CardView crd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            discount = itemView.findViewById(R.id.discount);
            amount = itemView.findViewById(R.id.amount);
            disc_amount = itemView.findViewById(R.id.discount_amount);
            img = itemView.findViewById(R.id.img);
            crd = itemView.findViewById(R.id.cardview);
            prd_name = itemView.findViewById(R.id.prd_name);
        }
    }
}
