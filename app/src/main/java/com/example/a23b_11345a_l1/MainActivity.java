package com.example.a23b_11345a_l1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.a23b_11345a_l1.Logic.GameManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageView main_IMG_background;
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
        Glide
                .with(this)
                .load("https://images.pexels.com/photos/1450082/pexels-photo-1450082.jpeg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(main_IMG_background);
        refreshUI();

        setAnswersClickListeners();
    }

    private void setAnswersClickListeners() {
        for (MaterialButton mb : main_BTN_options) {
            mb.setOnClickListener(v -> clicked(mb.getText().toString()));
        }
    }

    private void clicked(String selectedAnswer) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        gameManager.checkAnswer(getApplicationContext() ,v, selectedAnswer);
        refreshUI();
    }

    private void refreshUI() {
        if (gameManager.isGameEnded()){
            openScoreScreen("Winner", gameManager.getScore());
        }else if (gameManager.isLose()){
            openScoreScreen("Game Over", gameManager.getScore());
        }else{
            main_IMG_flag.setImageResource(gameManager.getCurrentQuestion().getImageResource());
            main_LBL_score.setText(""+ gameManager.getScore());
            ArrayList<String> answers = new ArrayList<>(Arrays.asList(gameManager.getCurrentQuestion().getAnswers()));
            Collections.shuffle(answers);
            for (int i = 0; i < answers.size(); i++) {
                main_BTN_options[i].setText(answers.get(i));
            }
            if(gameManager.getWrong() != 0)
                main_IMG_hearts[main_IMG_hearts.length - gameManager.getWrong()].setVisibility(View.INVISIBLE);
        }
    }

    private void openScoreScreen(String status, int score) {
        Intent scoreIntent = new Intent(this, ScoreActivity.class);
        scoreIntent.putExtra(ScoreActivity.KEY_SCORE, score);
        scoreIntent.putExtra(ScoreActivity.KEY_STATUS, status);
        startActivity(scoreIntent);
        finish();
    }


    private void findViews() {
        main_IMG_background = findViewById(R.id.main_IMG_background);
        main_BTN_options = new MaterialButton[]{
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