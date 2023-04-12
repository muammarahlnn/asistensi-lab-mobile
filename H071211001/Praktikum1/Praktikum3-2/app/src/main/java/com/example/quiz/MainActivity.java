package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private Button optiona, optionb, optionc, optiond, optione, nextbutton;
    private int indexquestion = 0;
    private String[] question = {
            "Siapa paling ganteng di Haikyuu?",
            "Siapa yang melakukan rumbling di Attack on Titan?",
            "Siapa presiden ke-6 Indonesia?",
            "Apa senjata yang dipakai Wanwan di Mobile Legend?",
            "Yang termasuk produk air mineral adalah...."
    };

    private String[][] option = {
            {"Hinata Shoyo", "Kageyama Tobio", "Miya Atsumu", "Miya Osamu", "Oikawa Toru"},
            {"Eren", "Levi", "Hanji", "Mikasa", "Erwin"},
            {"Jokowi", "Susilo Bambang Yudhoyono", "Puan Maharani", "Megawati Soekarno", "Prabowo"},
            {"Tangmen", "Busur", "Boomerang", "Pedang", "Tombak"},
            {"Le minerale", "Cimory", "Teh Pucuk", "Teh kotak", "Coca-cola"}
    };

    private int[] answer = {0, 0, 1, 0, 0};
    private long startTime;
    private String st1,st2;
    private Bundle bundle;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTime = System.currentTimeMillis();

        questionText = findViewById(R.id.textview);
        optiona = findViewById(R.id.option1);
        optionb = findViewById(R.id.optiona);
        optionc = findViewById(R.id.optionb);
        optiond = findViewById(R.id.optionc);
        optione = findViewById(R.id.optiond);
        nextbutton = findViewById(R.id.nextbutton);

        st1 = getIntent().getExtras().getString("text1");
        st2 = getIntent().getExtras().getString("text2");
        bundle = getIntent().getExtras().getBundle("image");


        displayquestion();

        optiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optiona);
            }
        });

        optionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optionb);
            }
        });

        optionc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optionc);
            }
        });

        optiond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optiond);
            }
        });

        optione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optione);
            }
        });

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexquestion++;

                displayquestion();
            }
        });

    }

    private void checkAnswer(Button selectedButton) {
        int correctAnswerIndex = answer[indexquestion];
        int selectedAnswerIndex = -1;
        switch (selectedButton.getId()) {
            case R.id.option1:
                selectedAnswerIndex = 0;
                break;
            case R.id.optiona:
                selectedAnswerIndex = 1;
                break;
            case R.id.optionb:
                selectedAnswerIndex = 2;
                break;
            case R.id.optionc:
                selectedAnswerIndex = 3;
                break;
            case R.id.optiond:
                selectedAnswerIndex = 4;
                break;
        }
        if (selectedAnswerIndex == correctAnswerIndex) {
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();

            ScoreActivity.correctAnswers++;
        } else {
            Toast.makeText(this, "Salah", Toast.LENGTH_SHORT).show();
        }
        // Disable all buttons
        optiona.setEnabled(false);
        optionb.setEnabled(false);
        optionc.setEnabled(false);
        optiond.setEnabled(false);
        optione.setEnabled(false);
    }

    private void displayquestion() {

        if(indexquestion<question.length){
            questionText.setText(question[indexquestion]);
            optiona.setText(option[indexquestion][0]);
            optionb.setText(option[indexquestion][1]);
            optionc.setText(option[indexquestion][2]);
            optiond.setText(option[indexquestion][3]);
            optione.setText(option[indexquestion][4]);

            optiona.setEnabled(true);
            optionb.setEnabled(true);
            optionc.setEnabled(true);
            optiond.setEnabled(true);
            optione.setEnabled(true);
        }else{

            double time = (System.currentTimeMillis()-startTime)/1000;
            int correctAnswers = ScoreActivity.correctAnswers;
            int totalQuestions = question.length;
            int maxTime = 60;
            int maxScore = 500;

            double baseScore = (double) correctAnswers * 100;
            double timeScore = ((maxTime - time) / maxTime) * 100;
            double finalScore = Math.min((baseScore / (time / totalQuestions) + timeScore), maxScore);

            int score = (int) finalScore;
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);

            intent.putExtra("text1",st1);
            intent.putExtra("text2",st2);
            intent.putExtra("image",bundle);

            intent.putExtra("Score",score);

            startActivity(intent);
        }
    }
}
