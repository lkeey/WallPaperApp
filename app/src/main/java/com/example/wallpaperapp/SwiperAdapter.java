package com.example.wallpaperapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class SwiperAdapter extends RecyclerView.Adapter<SwiperAdapter.SwiperHolder> {

    private List<WallPaperModel> list;
    Context context;


    public SwiperAdapter(Context context, List<WallPaperModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SwiperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_swiper, parent, false);


        return new SwiperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwiperHolder holder, int position) {
        Random random = new Random();

        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

        holder.constraintLayout.setBackgroundColor(color);

        Glide.with(context.getApplicationContext())
                .load(list.get(position).getImage())
                .timeout(6500)
                .listener(new RequestL);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SwiperHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private ConstraintLayout constraintLayout;

        public SwiperHolder(@NonNull View itemView) {
            super(itemView);

            itemView = itemView.findViewById(R.id.imageView);
            constraintLayout = itemView.findViewById(R.id.consLayout);
        }
    }
}
