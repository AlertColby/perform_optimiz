package com.demo.profiler;

import android.app.Application;
import android.os.Debug;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        String logDate = format.format(new Date());
        Debug.startMethodTracing("tracing-" + logDate);
    }
}
