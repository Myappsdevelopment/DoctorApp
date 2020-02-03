package com.mad.grubx.Tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.mad.grubx.Model.DataModel;
import com.mad.grubx.Model.DataModel2;
import com.mad.grubx.Product_Details;
import com.mad.grubx.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OnGoing extends Fragment {
    View view;
    RecyclerView ongoing_recycler;
    private List<DataModel2> datamodel;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_on_going, container, false);
        init();

        datamodel = new ArrayList<>();

        Data();


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        ongoing_recycler.setLayoutManager(mLayoutManager);
        OnGoingListAdapter mAdapter = new OnGoingListAdapter(getContext(), datamodel);
        ongoing_recycler.setAdapter(mAdapter);


        return view;
    }

    private void Data() {

        DataModel2 data = new DataModel2("Icead Tea, Brisk", "155", "One", "November 28", "Cash On Delivery", "1 Day",
                "XF10DD147", "Friday,November,29", "Currently in Transit", R.drawable.img2);
        datamodel.add(data);

        data = new DataModel2("Cidre Apple", "350", "One", "November 29", "Cash On Delivery", "1 Day",
                "AZXCVBN256", "Monday,December,02", "Out of Delivery", R.drawable.img3);
        datamodel.add(data);

        data = new DataModel2("Icead Tea, Brisk", "155", "One", "November 28", "Cash On Delivery", "1 Day",
                "XF10DD147", "Friday,November29", "Currently in Transit", R.drawable.img2);
        datamodel.add(data);
    }

    private void init() {
        ongoing_recycler = view.findViewById(R.id.recycler_ongoing);
    }


    private class OnGoingListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<DataModel2> data1;

        public OnGoingListAdapter(Context context, List<DataModel2> datamodel) {
            this.context = context;
            this.data1 = datamodel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_myorders, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final DataModel2 data = data1.get(position);

            holder.order_no.setText(data.getOrd_no());
            holder.expected_delivery.setText(data.getExpected_delivery());
            holder.status.setText(data.getStatus());
            holder.prd_name.setText(data.getPrd_name());
            holder.prd_price.setText(data.getPrd_prize());
            holder.prd_quantity.setText(data.getQuantity());
            holder.prd_placed_on.setText(data.getPlaces_on());
            holder.prd_payment.setText(data.getPayment());
            holder.prd_duration.setText(data.getDuration());
            holder.img.setImageResource(data.getImg());

            holder.view.setVisibility(View.GONE);

        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView order_no, expected_delivery, status, prd_name, prd_price, prd_quantity, prd_placed_on, prd_payment, prd_duration;
        ImageView img, view;
        CardView crd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            order_no = itemView.findViewById(R.id.order_no);
            expected_delivery = itemView.findViewById(R.id.delivery);
            status = itemView.findViewById(R.id.status);
            prd_name = itemView.findViewById(R.id.prd1_name);
            prd_price = itemView.findViewById(R.id.price);
            prd_quantity = itemView.findViewById(R.id.prd_quantity);
            prd_placed_on = itemView.findViewById(R.id.placed_on);
            prd_payment = itemView.findViewById(R.id.payment_mode);
            prd_duration = itemView.findViewById(R.id.duration);
            img = itemView.findViewById(R.id.prd_img);
            view = itemView.findViewById(R.id.view);

        }
    }
}
