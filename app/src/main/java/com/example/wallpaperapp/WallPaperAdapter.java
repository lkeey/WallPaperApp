package com.example.wallpaperapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class WallPaperAdapter extends RecyclerView.Adapter<WallPaperAdapter.WallPaperHolder> {

    private List<WallPaperModel> list;

    public WallPaperAdapter(List<WallPaperModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public WallPaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_item, parent, false);

        return new WallPaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallPaperHolder holder, int position) {
        Random random = new Random();

        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

        Glide.with(holder.itemView.getContext().getApplicationContext())
                .load(list.get(position).getImage())
                .timeout(7500)
                .placeholder(new ColorDrawable(color))
                .into(holder.wallImage);


        Glid

        holder.setOnClickedListener();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class WallPaperHolder extends RecyclerView.ViewHolder {

        private ImageView wallImage;

        public WallPaperHolder(@NonNull View itemView) {
            super(itemView);

            wallImage = itemView.findViewById(R.id.imageWallPaper);
        }

        private void setOnClickedListener() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    Intent intent = new Intent(itemView.getContext().getApplicationContext(), SwiperActivity.class);
                    intent.putExtra("position", position);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
