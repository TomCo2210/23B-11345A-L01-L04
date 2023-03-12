package com.example.a23b_11345a_l1.Models;

public class Question {

    private String[] answers;
    private String correctAnswer;
    private int imageResource;

    public Question() {
    }

    public String[] getAnswers() {
        return answers;
    }

    public Question setAnswers(String[] answers) {
        this.answers = answers;
        return this;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Question setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public int getImageResource() {
        return imageResource;
    }

    public Question setImageResource(int imageResource) {
        this.imageResource = imageResource;
        return this;
    }
}
