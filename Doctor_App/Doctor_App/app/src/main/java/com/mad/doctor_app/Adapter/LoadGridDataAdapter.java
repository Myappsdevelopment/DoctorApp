package com.mad.doctor_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.mad.doctor_app.Activity.Hospitals_List;
import com.mad.doctor_app.Activity.Item;
import com.mad.doctor_app.Activity.MainActivity;
import com.mad.doctor_app.R;

import java.util.ArrayList;

public class LoadGridDataAdapter extends ArrayAdapter<Item> {
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
            holder.txtTitle = row.findViewById(R.id.title);
            holder.imageItem = row.findViewById(R.id.img);
            holder.grid_item = row.findViewById(R.id.grid_item);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Item item = data.get(position);
        holder.txtTitle.setText(item.getName());
        holder.imageItem.setImageResource(item.getIcons());

        holder.grid_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, Hospitals_List.class);
                context.startActivity(in);
            }
        });

        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
        CardView grid_item;

    }
}
