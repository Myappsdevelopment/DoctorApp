package com.mad.doctor_app.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.mad.doctor_app.R;

import java.util.ArrayList;

public class LoadNumbersAdapter extends ArrayAdapter<Item_token> {

    Context context;
    int layoutResourceId;
    ArrayList<Item_token> data = new ArrayList<Item_token>();

    public LoadNumbersAdapter(Request_Token_Activity request_token_activity, int list_item_tokens, ArrayList<Item_token> arrayList) {
        super(request_token_activity, list_item_tokens, arrayList);
        this.context = request_token_activity;
        this.layoutResourceId = list_item_tokens;
        data = arrayList;
    }


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.number = row.findViewById(R.id.btn_number);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Item_token item = data.get(position);
        holder.number.setText(Integer.toString(item.getNumber()));

        final RecordHolder finalHolder = holder;
       /* holder.number.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                if (finalHolder.number.getDrawingCacheBackgroundColor() != R.color.grey) {
                    finalHolder.number.setBackgroundColor(R.color.green);
                } else {
                    finalHolder.number.setBackgroundColor(R.color.white);
                }
            }
        });
*/

        return row;

    }

    static class RecordHolder {
        TextView number;


    }
}
