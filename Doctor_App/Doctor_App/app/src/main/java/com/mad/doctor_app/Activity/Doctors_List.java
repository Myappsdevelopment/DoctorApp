package com.mad.doctor_app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.doctor_app.R;

import java.util.ArrayList;

public class Doctors_List extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item1> arrayList = new ArrayList<>();
    LoadDoctorsDataAdapter loadDoctorsDataAdapter;
    ImageView back_arrow, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors__list);

        init();

        arrayList.add(new Item1("Alisa", R.drawable.dctr1, "Neurologist", "Ph.D", "AVAILABLE"));
        arrayList.add(new Item1("Chris Brown", R.drawable.dctr2, "Neurologist specialist", "MBBS", "AVAILABLE"));
        arrayList.add(new Item1("Alisa Kolex", R.drawable.dctr1, "Orthologyst", "MBBS", "UNAVAILABLE"));
        arrayList.add(new Item1("Hendry", R.drawable.dctr1, "Surgen", "Ph.D", "AVAILABLE"));
        arrayList.add(new Item1("Rakesh", R.drawable.dctr2, "surgen", "MBBS", "UNAVAILABLE"));
        arrayList.add(new Item1("Alisa", R.drawable.dctr2, "Neurologist", "Ph.D", "AVAILABLE"));
        arrayList.add(new Item1("Chris Brown", R.drawable.dctr1, "Neurologist specialist", "MBBS", "AVAILABLE"));
        arrayList.add(new Item1("Alisa Kolex", R.drawable.dctr1, "Orthologyst", "MBBS", "UNAVAILABLE"));
        arrayList.add(new Item1("Hendry", R.drawable.dctr2, "Surgen", "Ph.D", "AVAILABLE"));
        arrayList.add(new Item1("Rakesh", R.drawable.dctr2, "surgen", "MBBS", "UNAVAILABLE"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadDoctorsDataAdapter = new LoadDoctorsDataAdapter(this, arrayList);
        recyclerView.setAdapter(loadDoctorsDataAdapter);
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_doctors_list);
        back_arrow = findViewById(R.id.back_arrow_doctor_list);
        home = findViewById(R.id.home_img_doctor_list);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Doctors_List.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
            }
        });

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    private class LoadDoctorsDataAdapter extends RecyclerView.Adapter<ViewHolder> {
        Context context;
        private ArrayList<Item1> list_chapters;

        public LoadDoctorsDataAdapter(Context applicationContext, ArrayList<Item1> list_subject_chapters) {
            this.context = applicationContext;
            this.list_chapters = list_subject_chapters;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_doctorlist, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @SuppressLint("ResourceAsColor")
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Item1 data = list_chapters.get(position);

            holder.txt_name.setText(data.getName());
            holder.txt_qualification.setText(data.getAddress());
            holder.txt_course.setText(data.getRatings());
            holder.txt_status.setText(data.getStatus());
            holder.image.setImageResource(data.getIcon());

            if (data.getStatus().equals("AVAILABLE")) {
                holder.txt_status.setTextColor(Color.parseColor("#4db874"));
            } else if (data.getStatus().equals("UNAVAILABLE")) {
                holder.txt_status.setTextColor(Color.parseColor("#dc4e42"));
            }

            holder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, Hosital_Details_Activity.class);
                    startActivity(intent);
                }
            });


        }

        @Override
        public int getItemCount() {
            return list_chapters.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name, txt_qualification, txt_course, txt_status;
        ImageView image;
        CardView crd;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_doctorname);
            txt_qualification = itemView.findViewById(R.id.txt_doctor_qualification);
            txt_course = itemView.findViewById(R.id.txt_doctor_course);
            txt_status = itemView.findViewById(R.id.txt_status);
            image = itemView.findViewById(R.id.img_doctor);
            crd = itemView.findViewById(R.id.crd_doctor_list);

        }

    }
}
