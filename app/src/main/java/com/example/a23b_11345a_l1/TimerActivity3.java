package com.example.a23b_11345a_l1;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity3 extends AppCompatActivity {

    public final int DELAY = 1000;

    private MaterialTextView time_LBL_time;
    private ExtendedFloatingActionButton time_FAB_start;
    private ExtendedFloatingActionButton time_FAB_stop;

    long startTime = 0;

    private CountDownTimer timer;

    private void updateTimeUI() {
        Log.d("TimerCount: ", "" + System.currentTimeMillis());
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        int hours = minutes / 60;
        minutes %= 60;
        hours %= 24;

        time_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        findViews();
        initView();
    }

    private void initView() {
        time_FAB_start.setOnClickListener(v -> startTime());
        time_FAB_stop.setOnClickListener(v -> stopTime());
    }

    private void stopTime() {
        timer.cancel();
    }

    private void startTime() {
        startTime = System.currentTimeMillis();
        if (timer == null) {
            timer = new CountDownTimer(999999999, DELAY) {
                @Override
                public void onTick(long millisUntilFinished) {
                    Log.d("TimerCount: ", " Thread: " + Thread.currentThread().getName());
                    updateTimeUI();
                }

                @Override
                public void onFinish() {
                    timer.cancel();
                }
            }.start();


        }
    }

    private void findViews() {
        time_LBL_time = findViewById(R.id.time_LBL_time);
        time_FAB_start = findViewById(R.id.time_FAB_start);
        time_FAB_stop = findViewById(R.id.time_FAB_stop);
    }
}