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

import com.mad.grubxvendor.Model.MessageModel;
import com.mad.grubxvendor.Model.NotificationDataModel;
import com.mad.grubxvendor.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Notifications extends Fragment {

    View view;
    RecyclerView ongoing_recycler;
    private List<NotificationDataModel> datamodel;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_notifications, container, false);

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

        NotificationDataModel data = new NotificationDataModel(R.drawable.img2, "Lorea James", "8 mints ago");
        datamodel.add(data);

        data = new NotificationDataModel(R.drawable.img2, "Alex Xander", "10 Mints ago");
        datamodel.add(data);


    }

    private void init() {
        ongoing_recycler = view.findViewById(R.id.recycler_notify);
    }


    private class OnGoingListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<NotificationDataModel> data1;

        public OnGoingListAdapter(Context context, List<NotificationDataModel> datamodel) {
            this.context = context;
            this.data1 = datamodel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_notifications, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final NotificationDataModel data = data1.get(position);

            holder.name.setText(data.getName());
            holder.time.setText(data.getTime());
            holder.img.setImageResource(data.getImage());


        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, time;
        ImageView img;
        CardView crd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time_txt);

            img = itemView.findViewById(R.id.img);

        }
    }

}
