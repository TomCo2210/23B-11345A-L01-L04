package com.example.a23b_11345a_l1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.a23b_11345a_l1.Logic.GameManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_score;
    private MaterialButton[] main_BTN_options;
    private ShapeableImageView[] main_IMG_hearts;
    private ShapeableImageView main_IMG_flag;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        gameManager = new GameManager(main_IMG_hearts.length);

        refreshUI();

setAnswersClickListeners();
    }

    private void setAnswersClickListeners() {
        for (MaterialButton mb: main_BTN_options) {
            mb.setOnClickListener(v -> clicked(mb.getText().toString()));
        }
    }

    private void clicked(String selectedAnswer) {

    }

    private void refreshUI() {
    }


    private void decreaseScore() {
        this.score -= 100;
        main_LBL_score.setText(score + "");
    }

    private void increaseScore() {
        this.score += 100;
        main_LBL_score.setText(score + "");
    }

    private void findViews() {
        main_BTN_options = new MaterialButton[] {
                findViewById(R.id.main_BTN_option1),
                findViewById(R.id.main_BTN_option2),
                findViewById(R.id.main_BTN_option3),
                findViewById(R.id.main_BTN_option4)};
        main_IMG_hearts = new ShapeableImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)};
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
    }
}