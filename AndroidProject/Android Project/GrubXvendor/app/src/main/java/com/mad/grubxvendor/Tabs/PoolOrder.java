package com.mad.grubxvendor.Tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubxvendor.Model.DataModelPending;
import com.mad.grubxvendor.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class PoolOrder extends Fragment {
    View view;
    RecyclerView ongoing_recycler;
    private List<DataModelPending> datamodel;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pool__orders, container, false);

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

        DataModelPending data = new DataModelPending("Icead Tea, Brisk", "155", "One", "November 28", "Done", "Apply",
                "XF10DD147", "Alberta, Street 02 LN", "Icead Tea, Brisk", R.drawable.img2);
        datamodel.add(data);

        data = new DataModelPending("Cidre Apple", "350", "One", "November 29", "Done", "Apply",
                "AZXCVBN256", "Alberta, Street 03 LN", "Cidre Apple", R.drawable.img3);
        datamodel.add(data);

        data = new DataModelPending("Icead Tea, Brisk", "155", "One", "November 28", "Not Done", "Apply",
                "XF10DD147", "Alberta, Street 04 LN", "Icead Tea, Brisk", R.drawable.img2);
        datamodel.add(data);
    }

    private void init() {
        ongoing_recycler = view.findViewById(R.id.recycler_poolorders);
    }


    private class OnGoingListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<DataModelPending> data1;

        public OnGoingListAdapter(Context context, List<DataModelPending> datamodel) {
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

            final DataModelPending data = data1.get(position);

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

            holder.img_chat_user.setVisibility(View.GONE);
            holder.txt_chatuser.setVisibility(View.GONE);

            holder.img_track.setVisibility(View.GONE);
            holder.txt_track.setVisibility(View.GONE);

            holder.img_cancel.setVisibility(View.VISIBLE);
            holder.txt_cancel.setVisibility(View.VISIBLE);

            holder.img_accept.setVisibility(View.GONE);
            holder.txt_accept.setVisibility(View.GONE);

        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView order_no, expected_delivery, status, prd_name, prd_price, prd_quantity, prd_placed_on, prd_payment, prd_duration, txt_cancel, txt_chatuser, txt_track, txt_accept;
        ImageView img, img_cancel, img_chat_user, img_track, img_accept;
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

            txt_cancel = itemView.findViewById(R.id.cancel_txt);
            txt_chatuser = itemView.findViewById(R.id.txt_chatuser);
            txt_track = itemView.findViewById(R.id.txt_track);
            txt_accept = itemView.findViewById(R.id.txt_accept);

            img_cancel = itemView.findViewById(R.id.cancel_img);
            img_chat_user = itemView.findViewById(R.id.chat_user_img);
            img_track = itemView.findViewById(R.id.track_img);
            img_accept = itemView.findViewById(R.id.accept_img);

        }
    }
}
