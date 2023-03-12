package com.example.a23b_11345a_l1.Logic;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import com.example.a23b_11345a_l1.Models.Question;

import java.util.ArrayList;

public class GameManager {
    private final int CORRECT_ANSWER_SCORE = 10;

    private int score;
    private int currentQ;
    private int wrong;
    private int life;

    private ArrayList<Question> questions;

    public GameManager(int life) {
        this.life = life;
        this.score = 0;
        this.currentQ = 0;
        this.wrong = 0;
        questions = DataManager.getQuestions();
    }

    public int getScore() {
        return score;
    }

    public int getWrong() {
        return wrong;
    }

    public int getLife() {
        return life;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQ);
    }

    public boolean isGameEnded() {
        return currentQ == questions.size();
    }

    public boolean isLose() {
        return life == wrong;
    }

    public void checkAnswer(Vibrator v, String selectedAnswer) {
        if (getCurrentQuestion().getCorrectAnswer().equals(selectedAnswer)) //answer was correct
        {
            score += CORRECT_ANSWER_SCORE;
        } else { // incorrect
            wrong++;
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v.vibrate(500);
            }
        }
        currentQ++;
    }
}
