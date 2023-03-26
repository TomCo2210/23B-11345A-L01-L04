package com.example.a23b_11345a_l1;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity2 extends AppCompatActivity {

    public final int DELAY = 1000;

    private MaterialTextView time_LBL_time;
    private ExtendedFloatingActionButton time_FAB_start;
    private ExtendedFloatingActionButton time_FAB_stop;

    long startTime = 0;

    private Timer timer;

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
        if (timer != null)
            timer.cancel();
    }

    private void startTime() {
        if (timer == null) {
            startTime = System.currentTimeMillis();
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Log.d("TimerCount: ", " Thread: " + Thread.currentThread().getName());
                    runOnUiThread(() -> {
                        Log.d("TimerCount: ", " Thread: " + Thread.currentThread().getName());
                        updateTimeUI();

                    });
                }
            }, 0, DELAY);
        }
    }

    private void findViews() {
        time_LBL_time = findViewById(R.id.time_LBL_time);
        time_FAB_start = findViewById(R.id.time_FAB_start);
        time_FAB_stop = findViewById(R.id.time_FAB_stop);
    }
}