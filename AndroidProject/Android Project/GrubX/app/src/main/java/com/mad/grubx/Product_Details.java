package com.mad.grubx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.grubx.Model.DataModel;
import com.mad.grubx.Tabs.Trending;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.security.AccessController.getContext;

public class Product_Details extends AppCompatActivity {
    RecyclerView recyclerView;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.img3, R.drawable.img3, R.drawable.img3, R.drawable.img3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    private List<DataModel> datamodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details);

        init();

        datamodel = new ArrayList<>();
        Data();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        ProductDetailsListAdapter mAdapter = new ProductDetailsListAdapter(getApplicationContext(), datamodel);
        recyclerView.setAdapter(mAdapter);

        PagerView();


    }

    private void PagerView() {


        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager.setAdapter(new SlidingImage_Adapter(Product_Details.this, ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
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

        recyclerView = findViewById(R.id.prd_details_recycler);
        mPager = findViewById(R.id.pager);
    }


    public class SlidingImage_Adapter extends PagerAdapter {


        private ArrayList<Integer> IMAGES;
        private LayoutInflater inflater;
        private Context context;


        public SlidingImage_Adapter(Context context, ArrayList<Integer> IMAGES) {
            this.context = context;
            this.IMAGES = IMAGES;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return IMAGES.size();
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

            assert imageLayout != null;
            final ImageView imageView = (ImageView) imageLayout
                    .findViewById(R.id.image);


            imageView.setImageResource(IMAGES.get(position));

            view.addView(imageLayout, 0);

            return imageLayout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }


    }


    private class ProductDetailsListAdapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        private List<DataModel> data1;

        public ProductDetailsListAdapter(Context context, List<DataModel> datamodel) {
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
            holder.disc_amount.setText(data.getPrd_strikeamount());
            holder.img.setImageResource(data.getImage());



            holder.disc_amount.setPaintFlags(holder.disc_amount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }


        @Override
        public int getItemCount() {
            return data1.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView discount, amount, disc_amount;
        ImageView img;
        CardView crd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            discount = itemView.findViewById(R.id.discount);
            amount = itemView.findViewById(R.id.amount);
            disc_amount = itemView.findViewById(R.id.discount_amount);
            img = itemView.findViewById(R.id.img);
            crd = itemView.findViewById(R.id.cardview);

        }
    }
}
