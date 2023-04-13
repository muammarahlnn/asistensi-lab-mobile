package com.example.praktikum3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    int totalscore = 0;
    private final String EXTRA_PROFILE_PICTURE = "EXTRA_PROFILE_PICTURE";
    private final String EXTRA_USERNAME = "EXTRA_USERNAME";
    private final String EXTRA_SCORE = "EXTRA_SCORE";
    private final String EXTRA_HIGHSCORE = "EXTRA_HIGHSCORE";
    TextView quizNumber, question;
    Button answer1, answer2, answer3 , answer4;
    String[][] soal = {
            {"1+1", "2", "1", "3", "4", "100"},
            {"1+2", "3", "4", "5", "25", "100"},
            {"1+3", "4", "5", "6", "35", "100"},
            {"3+3", "6", "5", "7", "8", "100"},
            {"4+1", "5", "6", "7", "8", "100"},
            {"5+5", "10", "11", "12", "13", "100"},
            {"2x3", "6", "10", "20", "9", "100"},
            {"1x1", "1", "0.1", "0.01", "0.001", "100"},
            {"2x5", "10", "15", "25", "50", "100"},
            {"6x3", "18", "21", "15", "9", "100"}
    };
    int[] soal_terpilih = generateRandomNumbers(5, 0, 9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = findViewById(R.id.question);
        quizNumber = findViewById(R.id.quizNumber);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);

        int[] jawaban_acak = generateRandomNumbers(4, 1, 4);
        question.setText(soal[soal_terpilih[0]][0]);
        answer1.setText(soal[soal_terpilih[0]][jawaban_acak[0]]);
        answer2.setText(soal[soal_terpilih[0]][jawaban_acak[1]]);
        answer3.setText(soal[soal_terpilih[0]][jawaban_acak[2]]);
        answer4.setText(soal[soal_terpilih[0]][jawaban_acak[3]]);

    }

    public static int[] generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        Set<Integer> generated = new HashSet<>();
        int[] randomNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            int number;
            do {
                number = random.nextInt((max - min) + 1) + min;
            } while (generated.contains(number));
            randomNumbers[i] = number;
            generated.add(number);
        }
        return randomNumbers;
    }

    @Override
    public void onClick(View view) {
        Handler handler = new Handler();
        int i = Integer.parseInt(quizNumber.getText().toString());
        int[] jawaban_acak = generateRandomNumbers(4, 1, 4);
        String kunci_jawaban = soal[soal_terpilih[i-1]][1];
        if (i == 5) {

            if (view instanceof Button) {
                Button button = (Button) view;
                String selectedAnswer = button.getText().toString();

                if (selectedAnswer.equals(kunci_jawaban)) {
                    totalscore += Integer.valueOf(soal[soal_terpilih[i-1]][5]);
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.green));
                } else {
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.red));
                }
            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    String profileUriString = intent.getStringExtra(EXTRA_PROFILE_PICTURE);
                    String user_name = intent.getStringExtra(EXTRA_USERNAME);
                    String topScore = intent.getStringExtra(EXTRA_HIGHSCORE);
                    Uri profile_picture = Uri.parse(profileUriString);
                    Intent scoreIntent = new Intent(Quiz.this, Score.class);
                    scoreIntent.putExtra(EXTRA_USERNAME, user_name);
                    scoreIntent.putExtra(EXTRA_PROFILE_PICTURE, profile_picture.toString());
                    scoreIntent.putExtra(EXTRA_SCORE, String.valueOf(totalscore));
                    scoreIntent.putExtra(EXTRA_HIGHSCORE, topScore);
                    startActivity(scoreIntent);
                }
            }, 1000);


        } else {
            if (view instanceof Button) {
                Button button = (Button) view;
                String selectedAnswer = button.getText().toString();

                if (selectedAnswer.equals(kunci_jawaban)) {
                    totalscore += Integer.valueOf(soal[soal_terpilih[i]][5]);
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.green));
                } else {
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.red));
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setBackgroundTintList(getResources().getColorStateList(R.color.gray1));
                        question.setText(soal[soal_terpilih[i]][0]);
                        answer1.setText(soal[soal_terpilih[i]][jawaban_acak[0]]);
                        answer2.setText(soal[soal_terpilih[i]][jawaban_acak[1]]);
                        answer3.setText(soal[soal_terpilih[i]][jawaban_acak[2]]);
                        answer4.setText(soal[soal_terpilih[i]][jawaban_acak[3]]);
                        quizNumber.setText(String.valueOf(i+1));
                    }
                }, 1000);
            }
        }
    }
}