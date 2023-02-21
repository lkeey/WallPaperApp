package com.example.wallpaperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.viewpager2.widget.ViewPager2;

public class SwiperActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);
    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);

        position = getIntent().getIntExtra("position", 0);
    }

}