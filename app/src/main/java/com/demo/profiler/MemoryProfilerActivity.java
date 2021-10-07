package com.demo.profiler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;


public class MemoryProfilerActivity extends AppCompatActivity {

    public static Activity sActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_profiler);
        initData();
        initView();
    }



    private void initView() {
        getSupportActionBar().setTitle(getResources().getString(R.string.activity_mem_profiler_title));
    }

    private void initData() {
        sActivity = this;
    }
}
