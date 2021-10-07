package com.demo.profiler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;


public class EnergyProfilerActivity extends AppCompatActivity {

    private PowerManager.WakeLock mWakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_profiler);
        initView();
        acquireWakeLock();
    }

    private void initView() {
        getSupportActionBar().setTitle(getResources().getString(R.string.activity_energy_profiler_title));
    }

    private void acquireWakeLock() {
        if (mWakeLock == null) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            if (pm != null) {
                mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "ProfilerDemo::EnergyProfilerDemo");
                if (mWakeLock != null) {
                    mWakeLock.acquire(10 * 60 * 1000L);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWakeLock != null) {
            mWakeLock.release();
            mWakeLock = null;
        }
    }
}
