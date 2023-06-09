package com.attar.app_debug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.attar.app_debug.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;

    private String[] questions = new String[]{
        "Raja para dewa di mitologi yunani?",
        "Dalam kitab agama katolik ada berapa dosa besar?",
        "Apakah huruf keempat dalam abjad?",
        "Siapa nama ayah Mugiwara No Luffy?",
        "Kopi apa yang lucu?",
    };

    private String[][] answers = new String[][] {
        {"Hades", "Zeus", "Poseidon", "Ares"},
        {"9", "11", "7", "1"},
        {"A", "B", "C", "D"},
        {"Monkey D. Dragon", "Monkey D. Garp", "Portgas D. Ace", "Shanks"},
        {"Kapal Api", "Luwak White Coffee", "Kopi ABC", "Kopken"},
    };

    private String[] correctAnswers = new String[] {
        "Zeus",
        "7",
        "A",
        "Monkey D. Dragon",
        "Luwak White Coffee"
    };

    int currentNumber = 1;

    int score = 0;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = getIntent().getParcelableExtra("user");

        showQuiz(currentNumber);
        binding.tvPilihan1.setOnClickListener(view -> {
            answeringQuestion(currentNumber, 0);
            showQuiz(++currentNumber);
        });
        binding.tvPilihan2.setOnClickListener(view -> {
            answeringQuestion(currentNumber, 1);
            showQuiz(++currentNumber);
        });
        binding.tvPilihan3.setOnClickListener(view -> {
            answeringQuestion(currentNumber, 2);
            showQuiz(++currentNumber);
        });
        binding.tvPilihan4.setOnClickListener(view -> {
            answeringQuestion(currentNumber, 3);
            showQuiz(++currentNumber);
        });
    }

    private void showQuiz(int currentNumber) {
        if (currentNumber > 5) {
            user.setCurrentScore(score);
            if (score >= user.getBestScore()) {
                user.setBestScore(score);
            }
            Intent toResult = new Intent(QuizActivity.this, ResultActivity.class);
            toResult.putExtra("user", user);
            startActivity(toResult);
            return;
        }
        binding.tvTitle.setText("Quiz " + currentNumber + "of 5");
        binding.tvQuestion.setText(questions[currentNumber - 1]);
        binding.tvPilihan1.setText(answers[currentNumber - 1][0]);
        binding.tvPilihan2.setText(answers[currentNumber - 1][1]);
        binding.tvPilihan3.setText(answers[currentNumber - 1][2]);
        binding.tvPilihan4.setText(answers[currentNumber - 1][3]);
    }

    private void answeringQuestion(int currentNumber, int pilihan) {
        String userAnswer = answers[currentNumber - 1][pilihan];
        String correctAnswer = correctAnswers[currentNumber - 1];
        if (userAnswer.equals(correctAnswer)) {
            Toast.makeText(this, "BENAR", Toast.LENGTH_SHORT).show();
            score += 100;
        } else {
            Toast.makeText(this, "SALAH", Toast.LENGTH_SHORT).show();
        }
    }
}