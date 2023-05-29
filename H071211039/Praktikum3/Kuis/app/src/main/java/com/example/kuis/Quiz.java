package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Quiz extends AppCompatActivity {
    TextView Question, Title;
    Button OptionA, OptionB, OptionC, OptionD;
    String soal[] = new String[]{
            "Hewan apa yang jago berenang?",
            "Bahasa yang menunjukkan rasa ibah?",
            "Siapa admin ig sisfo",
            "Siapa nama asisten mobile Isty?",
            "Siapa yang paling baik sesisfo?"
    };
    String jawaban[][] = new String[][]{
            new String[] {"ayam","Bebek","ikan","unta"},
            new String[] {"Kodong","sundala","manre","gammara"},
            new String[] {"Uni","Astrina","Selvi","Adel"},
            new String[] {"Kak Ichsan","Kak rafly","Kak Ardhan","Kak Takdim"},
            new String[] {"Isty","Isty aja","Isty doang","Cuman Isty"}
    };
    String jawaban_benar[]= new String[]{
            "Bebek",
            "kodong",
            "Uni",
            "Kak Ardhan",
            "Isty",
    };

    int number = 0;
    int score = 0;
    int bestscore= 0;

    Photo photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Question = findViewById(R.id.pertanyaan);
        Title = findViewById(R.id.judul);
        OptionA = findViewById(R.id.optionA);
        OptionB = findViewById(R.id.optionB);
        OptionC = findViewById(R.id.optionC);
        OptionD = findViewById(R.id.optionD);
//        Pilihan = findViewById(R.id.rgPilihan);
//
//        Pilihan.check(0);
        showQuiz(number);

        bestscore = getIntent().getIntExtra("bestscore", 0);
        photo = getIntent().getParcelableExtra("PROFIL");

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                cekBenarSalah(number - 1, 0);
            }
        });

        OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                cekBenarSalah(number - 1, 1);
            }
        });

        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                cekBenarSalah(number - 1, 2);
            }
        });

        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                cekBenarSalah(number - 1, 3);
            }
        });



    }

    private void showQuiz(int number) {
        if (number == soal.length) {
            toDetailScore();
            return;
        }

        int questionNumber = number + 1;
        String title = "Question " + questionNumber + " of 5";
        Title.setText(title);
        Question.setText(soal[number]);
        OptionA.setText(jawaban[number][0]);
        OptionB.setText(jawaban[number][1]);
        OptionC.setText(jawaban[number][2]);
        OptionD.setText(jawaban[number][3]);

    }

    private void cekBenarSalah(int number, int pilihanJawaban) {
        if (number == soal.length) {
            toDetailScore();
            return;
        }
        String jawabanMu = jawaban[number][pilihanJawaban];
        String jawabanBenar = jawaban_benar[number];
        System.out.println(jawabanMu + " -- " + jawabanBenar);
        if (jawabanMu.equalsIgnoreCase(jawabanBenar)) {
            Toast.makeText(this, "Yeay benar", Toast.LENGTH_SHORT).show();
            score+=100;
        } else {
            Toast.makeText(this, "Aih salah", Toast.LENGTH_SHORT).show();
        }
    }
    private void toDetailScore() {
        Intent intent = getIntent();
        String Name = intent.getStringExtra("FULL NAME");

        if (score >= bestscore) {
            bestscore = score;
        }
        Intent toDetailScore = new Intent(Quiz.this, Detail_Score.class);
        toDetailScore.putExtra("FULL NAME", Name);
        toDetailScore.putExtra("score",score);
        toDetailScore.putExtra("bestscore",bestscore);
        toDetailScore.putExtra("PROFIL", photo);
        startActivity(toDetailScore);
    }
}