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

import com.mad.grubxvendor.Model.DataModel;
import com.mad.grubxvendor.Model.DataModelPending;
import com.mad.grubxvendor.Model.MessageModel;
import com.mad.grubxvendor.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Messages extends Fragment {

    View view;
    RecyclerView ongoing_recycler;
    private List<MessageModel> datamodel;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_messages, container, false);

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

        MessageModel data = new MessageModel(R.drawable.img2,"Andrea","Your Product is awsome mate","3:01 PM");
        datamodel.add(data);

        data = new MessageModel(R.drawable.img2,"Customer Support","One moment Please","11:01 PM");
        datamodel.add(data);

        data = new MessageModel(R.drawable.img2,"Jonathon Mathew","This time goods are not good","1:01 PM");
        datamodel.add(data);

        data = new MessageModel(R.drawable.img2,"Simson","We need more stock","5:01 PM");
        datamodel.add(data);


    }

    private void init() {
        ongoing_recycler = view.findViewById(R.id.recycler_message);
    }


    private class OnGoingListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<MessageModel> data1;

        public OnGoingListAdapter(Context context, List<MessageModel> datamodel) {
            this.context = context;
            this.data1 = datamodel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_msg_item_view, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final MessageModel data = data1.get(position);

            holder.name.setText(data.getName());
            holder.msg.setText(data.getMessage());
            holder.time.setText(data.getTime());
            holder.img.setImageResource(data.getImage());


        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, msg, time;
        ImageView img;
        CardView crd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg_txt);
            time = itemView.findViewById(R.id.time);

            img = itemView.findViewById(R.id.img);

        }
    }

}
