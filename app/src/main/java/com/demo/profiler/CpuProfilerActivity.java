package com.demo.profiler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class CpuProfilerActivity extends AppCompatActivity {

    public static final String TAG = "CpuProfilerActivity";

    private ProgressBar mProgressBar;
    private Button mBtnShot;
    private boolean mThreadRun;
    private int mPBValue;
    private final static int PB_MAX = 100;
    private final static int REFRESH_PROGRESS = 1;
    private final static int END_REFRESH_PROGRESS = 2;
    private MyHandler myHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu_profiler);
//        initData();
        initView();
    }

    private void initView() {
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setMax(PB_MAX);
        mBtnShot = findViewById(R.id.btnShot);
        mBtnShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShot();
            }
        });
    }

    private void initData() {
        initJobA(true);
        initJobC();
    }

    private void initJobC() {
        initJobA(true);
        initJobA(true);
        initJobA(false);
    }

    private void initJobA(boolean isNeedJobB) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isNeedJobB) {
            initJobB();
        }
    }

    private void initJobB() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void onShot() {
        mBtnShot.setEnabled(false);
        mThreadRun = true;
        mPBValue = 0;
        mProgressBar.setProgress(mPBValue);
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (mThreadRun) {
                   try {
                       Thread.sleep(1000/60);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   if (mPBValue > PB_MAX) {
                       mPBValue = 0;
                       mThreadRun = false;
                       myHandler.sendEmptyMessage(END_REFRESH_PROGRESS);
                   } else {
                       mPBValue++;
                       Message message = myHandler.obtainMessage();
                       message.what = REFRESH_PROGRESS;
                       message.arg1 = mPBValue;
                       myHandler.sendMessage(message);
                   }

                   Log.d(TAG, "PBVALUE:" + mPBValue);
               }
            }
        }).start();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case REFRESH_PROGRESS:
                    int progress = msg.arg1;
                    mProgressBar.setProgress(progress);
                    break;
                case END_REFRESH_PROGRESS:
                    mBtnShot.setEnabled(true);
                    break;
            }
        }
    }
}
