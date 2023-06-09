package com.example.parcelablequiz;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class QuizItem {
    private String questionSection, answer, option1, option2, option3, option4;
    private int score;

    public QuizItem(String questionSection, String answer, String option1, String option2, String option3, String option4, int score) {
        this.questionSection = questionSection;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getQuestionSection() {
        return questionSection;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

}
