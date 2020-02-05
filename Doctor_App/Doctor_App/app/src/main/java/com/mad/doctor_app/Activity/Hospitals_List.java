package com.mad.doctor_app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mad.doctor_app.Adapter.LoadGridDataAdapter;
import com.mad.doctor_app.R;

import java.util.ArrayList;
import java.util.List;

public class Hospitals_List extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item1> arrayList = new ArrayList<>();
    LoadHospitalDataAdapter loadHospitalDataAdapter;
    ImageView back_arrow, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals__list);

        init();

        arrayList.add(new Item1("Medicover Hospital", R.drawable.hsptl1, "Hitech City, Hyderabad, Near cyber towers", "4.5", ""));
        arrayList.add(new Item1("Image Hospital", R.drawable.hsptl2, "Begumpet, Hyderabad", "4.2", ""));
        arrayList.add(new Item1("Apolo Hospital", R.drawable.hsptl2, "Gachibowli, Hyderabad", "4.5", ""));
        arrayList.add(new Item1("Maxcure Hospital", R.drawable.hsptl1, "Hitech City, Hyderabad, Near Cyber towers", "4.5", ""));
        arrayList.add(new Item1("NIMS Hospital", R.drawable.hsptl1, "Punjaguta, Hyderabad, Near city center", "5.0", ""));
        arrayList.add(new Item1("Yashodha Hospital", R.drawable.hsptl2, "Secundrabad, Hyderabad, Near clock tower", "5.0", ""));
        arrayList.add(new Item1("Medicover Hospital", R.drawable.hsptl2, "Hitech City, Hyderabad, Near cyber towers", "4.5", ""));
        arrayList.add(new Item1("Image Hospital", R.drawable.hsptl1, "Begumpet, Hyderabad", "4.2", ""));
        arrayList.add(new Item1("Apolo Hospital", R.drawable.hsptl1, "Gachibowli, Hyderabad", "4.5", ""));
        arrayList.add(new Item1("Maxcure Hospital", R.drawable.hsptl2, "Hitech City, Hyderabad, Near Cyber towers", "4.5", ""));
        arrayList.add(new Item1("NIMS Hospital", R.drawable.hsptl2, "Punjaguta, Hyderabad, Near city center", "5.0", ""));
        arrayList.add(new Item1("Yashodha Hospital", R.drawable.hsptl1, "Secundrabad, Hyderabad, Near clock tower", "5.0", ""));


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadHospitalDataAdapter = new LoadHospitalDataAdapter(this, arrayList);
        recyclerView.setAdapter(loadHospitalDataAdapter);

    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_hospital_list);
        back_arrow = findViewById(R.id.back_arrow_hospital_list);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        home = findViewById(R.id.home_img_hospital_list);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Hospitals_List.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
            }
        });
    }

    private class LoadHospitalDataAdapter extends RecyclerView.Adapter<ViewHolder> {
        Context context;
        private ArrayList<Item1> list_chapters;

        public LoadHospitalDataAdapter(Context applicationContext, ArrayList<Item1> list_subject_chapters) {
            this.context = applicationContext;
            this.list_chapters = list_subject_chapters;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hospitallist, parent, false);

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Item1 data = list_chapters.get(position);

            holder.txt_name.setText(data.getName());
            holder.txt_address.setText(data.getAddress());
            holder.txt_ratings.setText(data.getRatings());
            holder.image.setImageResource(data.getIcon());

            holder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent in = new Intent(context, Doctors_List.class);
                    startActivity(in);
                }
            });


        }

        @Override
        public int getItemCount() {
            return list_chapters.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name, txt_address, txt_ratings;
        ImageView image;
        CardView crd;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_hospitalname);
            txt_address = itemView.findViewById(R.id.txt_hospitaladdress);
            txt_ratings = itemView.findViewById(R.id.txt_hospitalrating);
            image = itemView.findViewById(R.id.img_hospital);
            crd = itemView.findViewById(R.id.crd_hospitals_list);

        }

    }
}
