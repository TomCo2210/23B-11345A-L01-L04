package com.example.a23b_11345a_l1.Logic;

import com.example.a23b_11345a_l1.Models.Question;
import com.example.a23b_11345a_l1.R;

import java.util.ArrayList;

public class DataManager {

    private int[] images = new int[]{
            R.drawable.australia,
            R.drawable.azerbaijan,
            R.drawable.bahrain,
            R.drawable.belgium,
            R.drawable.bolivia,
            R.drawable.bulgaria,
            R.drawable.canada,
            R.drawable.costa_rica,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.hungary,
            R.drawable.ireland,
            R.drawable.poland,
            R.drawable.romania,
            R.drawable.ukraine,
            R.drawable.israel,
            R.drawable.switzerland,
            R.drawable.netherlands,
            R.drawable.singapore,
            R.drawable.italy,
            R.drawable.thailand,
            R.drawable.south_korea,
            R.drawable.spain,
            R.drawable.qatar,
            R.drawable.japan,
            R.drawable.united_states,
            R.drawable.russia
    };
    private String[] correctAnswers = {
            "australia",
            "azerbaijan",
            "bahrain",
            "belgium",
            "bolivia",
            "bulgaria",
            "canada",
            "costa rica",
            "france",
            "germany",
            "hungary",
            "ireland",
            "poland",
            "romania",
            "ukraine",
            "israel",
            "switzerland",
            "netherlands",
            "singapore",
            "italy",
            "thailand",
            "south korea",
            "spain",
            "qatar",
            "japan",
            "united states",
            "russia"
    };
    private String[][] answers;


    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < correctAnswers.length; i++) {
            Question q = new Question()
                    .setImageResource(images[i])
                    .setCorrectAnswer(correctAnswers[i])
                    .setAnswers(answers[i]);
            questions.add(q);
        }
        return questions;
    }
}
