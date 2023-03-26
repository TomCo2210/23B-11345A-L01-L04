package com.example.a23b_11345a_l1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class TimerActivity extends AppCompatActivity {

    public final int DELAY = 1000;

    private MaterialTextView time_LBL_time;
    private ExtendedFloatingActionButton time_FAB_start;
    private ExtendedFloatingActionButton time_FAB_stop;

    long startTime = 0;

    private final Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY); //Do it again in a second
            updateTimeUI();
        }
    };

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
        handler.removeCallbacks(runnable);
    }

    private void startTime() {
        startTime = System.currentTimeMillis();
        handler.postDelayed(runnable,DELAY);
    }

    private void findViews() {
        time_LBL_time = findViewById(R.id.time_LBL_time);
        time_FAB_start = findViewById(R.id.time_FAB_start);
        time_FAB_stop = findViewById(R.id.time_FAB_stop);
    }
}