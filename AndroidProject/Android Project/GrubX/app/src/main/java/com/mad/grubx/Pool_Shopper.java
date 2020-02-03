package com.mad.grubx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubx.Model.DataModel2;
import com.mad.grubx.Model.DataModel3;
import com.mad.grubx.Tabs.Pool_Orders;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Pool_Shopper extends AppCompatActivity {
    RecyclerView recycler_poolshopper;
    private List<DataModel3> datamodel;
    Button btn_proceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool__shopper);

        datamodel = new ArrayList<>();

        init();
        Data();


        init();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Pool_Shopper.this);
        recycler_poolshopper.setLayoutManager(mLayoutManager);
        Pool_Shopper_OrdersListAdapter mAdapter = new Pool_Shopper_OrdersListAdapter(Pool_Shopper.this, datamodel);
        recycler_poolshopper.setAdapter(mAdapter);

    }

    private void Data() {

        DataModel3 data = new DataModel3(R.drawable.person_img1, "Nirvana Shaker", "Nirvana restaurant owner");
        datamodel.add(data);
        data = new DataModel3(R.drawable.person_img1, "Alexa Lucifar", "Vintage Milk shake owner");
        datamodel.add(data);
    }

    private void init() {
        recycler_poolshopper = findViewById(R.id.recycler_poolshopper);
        btn_proceed = findViewById(R.id.btn_poolshopper);

        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Pool_Shopper.this, Payment.class);
                startActivity(in);
            }
        });
    }


    private class Pool_Shopper_OrdersListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<DataModel3> data1;

        public Pool_Shopper_OrdersListAdapter(Context context, List<DataModel3> datamodel) {
            this.context = context;
            this.data1 = datamodel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pool_shopper_itemview, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final DataModel3 data = data1.get(position);

            holder.person_name.setText(data.getName());
            holder.rest_name.setText(data.getHotel_name());
            holder.img.setImageResource(data.getImg());


        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView person_name, rest_name;
        ImageView img;
        CardView crd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            person_name = itemView.findViewById(R.id.user_name);
            rest_name = itemView.findViewById(R.id.user_hotelname);
            img = itemView.findViewById(R.id.img);


        }
    }


}
