package com.example.quiz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuest, soal;
    Button ans, ans2, ans3, ans4;

    int score = 0;
    int totalQuestion = QuesAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    Player player;

    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soal = findViewById(R.id.soal);
        ans = findViewById(R.id.ans);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        totalQuest = findViewById(R.id.totalQuestion);

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK){
                assert result.getData() !=null;
                Player player = result.getData().getParcelableExtra("player");
                Intent intent = new Intent();
                intent.putExtra("player", player);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        ans.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);

        totalQuest.setText(currentQuestionIndex+1 + "out of" + totalQuestion);
        loadNewQuestion();
    }
    void loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        totalQuest.setText(currentQuestionIndex+1 + " out of "+ totalQuestion);

        ans.setBackgroundColor(Color.WHITE);
        ans2.setBackgroundColor(Color.WHITE);
        ans3.setBackgroundColor(Color.WHITE);
        ans4.setBackgroundColor(Color.WHITE);

        soal.setText(QuesAnswer.question[currentQuestionIndex]);
        ans.setText(QuesAnswer.choice[currentQuestionIndex][0]);
        ans2.setText(QuesAnswer.choice[currentQuestionIndex][1]);
        ans3.setText(QuesAnswer.choice[currentQuestionIndex][2]);
        ans4.setText(QuesAnswer.choice[currentQuestionIndex][3]);
    }

    private void finishQuiz(){
        Intent next = new Intent(this, MainActivity2.class);
        next.putExtra("player", player);
        resultLauncher.launch(next);
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;

        selectedAnswer = String.valueOf(clickedButton.getText());

        if(selectedAnswer.equals(QuesAnswer.correctAns[currentQuestionIndex])){
            clickedButton.setBackgroundColor(Color.GREEN);
            score = score + 10;
            player.setScore(score);
            delay();
        }else{
            clickedButton.setBackgroundColor(Color.RED);
            delay();
        }
    }

    void delay(){
        currentQuestionIndex++;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNewQuestion();
            }
        }, 1000);
    }
}