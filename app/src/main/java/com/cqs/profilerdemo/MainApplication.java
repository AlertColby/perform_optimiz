package com.cqs.profilerdemo;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;

import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {

    public static List<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        enabledStrictMode();
        super.onCreate();
    }

    private void enabledStrictMode() {
        if (BuildConfig.DEBUG) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectCustomSlowCalls()
//                    .detectNetwork()
//                    .detectDiskWrites()
//                    .detectDiskReads()
//                    .penaltyLog()
//                    .penaltyDialog()
//                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
