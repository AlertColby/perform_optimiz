package com.demo.profiler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCPU(View view){
        Intent intent = new Intent(this, CpuProfilerActivity.class);
        startActivity(intent);
    }


    public void toMemory(View view){
        Intent intent = new Intent(this, MemoryProfilerActivity.class);
        startActivity(intent);
    }


    public void toNetwork(View view){
        Intent intent = new Intent(this, NetworkProfilerActivity.class);
        startActivity(intent);
    }


    public void toEnergy(View view){
        Intent intent = new Intent(this, EnergyProfilerActivity.class);
        startActivity(intent);
    }

}
