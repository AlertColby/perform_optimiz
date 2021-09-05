package com.cqs.profilerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        MainApplication.activities.add(this);
    }
}
