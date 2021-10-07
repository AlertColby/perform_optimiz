package com.demo.profiler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class NetworkProfilerActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_profiler);
        imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://img.jj20.com/up/allimg/tp04/1Z924232J54115-0-lp.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .centerInside()
                .into(imageView);
    }
}
