package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;

    int score = 0;
    int totalQuestion = Question.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    int bestScore=0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bestScore = getIntent().getIntExtra("best_score",0);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        totalQuestionsTextView.setText("Total questions : "+totalQuestion);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setEnabled(false);
        ansB.setEnabled(false);
        ansC.setEnabled(false);
        ansD.setEnabled(false);

        final Button clickedButton = (Button) view;
        selectedAnswer = clickedButton.getText().toString();
        if (selectedAnswer.equals(Question.Answers[currentQuestionIndex])) {
            score++;
            ansA.setBackgroundColor(Color.RED);
            ansB.setBackgroundColor(Color.RED);
            ansC.setBackgroundColor(Color.RED);
            ansD.setBackgroundColor(Color.RED);
            clickedButton.setBackgroundColor(Color.GREEN);
        } else {
            if (ansA.getText().toString().equals(Question.Answers[currentQuestionIndex])) {
                ansA.setBackgroundColor(Color.GREEN);
                ansB.setBackgroundColor(Color.RED);
                ansC.setBackgroundColor(Color.RED);
                ansD.setBackgroundColor(Color.RED);
            } else if (ansB.getText().toString().equals(Question.Answers[currentQuestionIndex])) {
                ansA.setBackgroundColor(Color.RED);
                ansB.setBackgroundColor(Color.GREEN);
                ansC.setBackgroundColor(Color.RED);
                ansD.setBackgroundColor(Color.RED);
            } else if (ansC.getText().toString().equals(Question.Answers[currentQuestionIndex])) {
                ansA.setBackgroundColor(Color.RED);
                ansB.setBackgroundColor(Color.RED);
                ansC.setBackgroundColor(Color.GREEN);
                ansD.setBackgroundColor(Color.RED);
            } else if (ansD.getText().toString().equals(Question.Answers[currentQuestionIndex])) {
                ansA.setBackgroundColor(Color.RED);
                ansB.setBackgroundColor(Color.RED);
                ansC.setBackgroundColor(Color.RED);
                ansD.setBackgroundColor(Color.GREEN);
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            ansA.setEnabled(true);
            ansB.setEnabled(true);
            ansC.setEnabled(true);
            ansD.setEnabled(true);

            ansA.setBackgroundColor(Color.WHITE);
            ansB.setBackgroundColor(Color.WHITE);
            ansC.setBackgroundColor(Color.WHITE);
            ansD.setBackgroundColor(Color.WHITE);

            currentQuestionIndex++;
            if (currentQuestionIndex < totalQuestion) {
                loadNewQuestion();
            } else {
                finishQuiz();
            }
        }, 1000);
    }
    @SuppressLint("SetTextI18n")
    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        selectedAnswer = "";
        List<String> questionList = Arrays.asList(Question.question);
        String currentQuestion = questionList.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion);

        List<String> choices = Arrays.asList(Question.choices[currentQuestionIndex]);
        Collections.shuffle(choices);
        ansA.setText(choices.get(0));
        ansB.setText(choices.get(1));
        ansC.setText(choices.get(2));
        ansD.setText(choices.get(3));
        totalQuestionsTextView.setText("Question " + (currentQuestionIndex + 1) + " of " + totalQuestion);

    }
    void finishQuiz() {
        String name = getIntent().getStringExtra("Fname");
        Uri selectedImage1 = getIntent().getParcelableExtra("image");
        Intent intent = new Intent(getApplicationContext(), Result.class);

        String passStatus;
        if (score >= totalQuestion * 0.60) {
            passStatus = "Nice Job!";
        } else {
            passStatus = "Nice Try";
        }
        intent.putExtra("status", passStatus);
        intent.putExtra("image", selectedImage1);
        intent.putExtra("Fname", name);
        intent.putExtra("Score", score * 20);

        int currentBestScore = getIntent().getIntExtra("best_score", 0);
        if (score > currentBestScore) {
            bestScore = score * 20;
        } else {
            bestScore = currentBestScore;
        }
        intent.putExtra("best_score", bestScore);
        startActivity(intent);
    }

}