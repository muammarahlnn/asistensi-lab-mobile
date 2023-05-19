package com.example.parcelablequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class quizactivity extends AppCompatActivity {
    private TextView questNumber, questSection;
    private QuizItem question1, question2, question3, question4, question5, question6, selectedQuestion;
    private AppCompatButton opsi1, opsi2, opsi3, opsi4;
    private Stack<QuizItem> questions = new Stack<>();
    //Kegunaan dari stack adalah untuk mengurutkan soal secara acak
    private int score = 0, questionNumber = 0;
    private ImageView imageProfileView;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);
        questNumber = findViewById(R.id.number_question);
        questSection = findViewById(R.id.textView4);
        opsi1 = findViewById(R.id.jawaban1);
        opsi2 = findViewById(R.id.jawaban2);
        opsi3 = findViewById(R.id.jawaban3);
        opsi4 = findViewById(R.id.jawaban4);

        user = getIntent().getParcelableExtra("user");

        //ToMakeQuestion
        makeQuestion();
        questions.addAll(Arrays.asList(question1, question2, question3, question4, question5, question6));
        Collections.shuffle(questions);
        selectedQuestion = questions.pop();
        setQuestion(selectedQuestion);

        opsi1.setOnClickListener(v -> { answerChecker(opsi1);});
        opsi2.setOnClickListener(v -> { answerChecker(opsi2);});
        opsi3.setOnClickListener(v -> { answerChecker(opsi3);});
        opsi4.setOnClickListener(v -> { answerChecker(opsi3);});

    }

    private void answerChecker(AppCompatButton button) {
        String answer = button.getText().toString();
        enableStatus(false);


        if(answer.equals(selectedQuestion.getAnswer())){
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Cerulean_Blue));
            score += selectedQuestion.getScore();
        }else{
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Red_Violet));
        }
        button.postDelayed(() ->{
            enableStatus(true);
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.French_Grey));
            selectedQuestion = questions.pop();
            setQuestion(selectedQuestion);
        }, 1500);
    }


    private void enableStatus(boolean status) {
        opsi1.setEnabled(status);
        opsi2.setEnabled(status);
        opsi3.setEnabled(status);
        opsi4.setEnabled(status);

    }

    private void setQuestion(QuizItem question) {
        questionNumber++;
        String imageProfile = getIntent().getStringExtra("imageProfile");
        if(questionNumber > 5){
            Intent intent = new Intent(this, DisplayScore.class );
            intent.putExtra("score", String.valueOf(score));
            intent.putExtra("user", user);
            intent.putExtra("imageProfile", imageProfile);
            startActivity(intent);
            finish();
        }else{
            questSection.setText(question.getQuestionSection());
            opsi1.setText(question.getOption1());
            opsi2.setText(question.getOption2());
            opsi3.setText(question.getOption3());
            opsi4.setText(question.getOption4());
            questNumber.setText(String.valueOf(questionNumber));
        }
    }

    private void makeQuestion() {
        question1 = new QuizItem("Siapa Penakluk Constantinopel?", "Muhammad Al-Fatih", "Thariq Bin Ziyad", "Murad 2","Muhammad Al-Fatih","Muawiyah",90);
        question2 = new QuizItem("Siapa Ayah Muhammad Al-Fatih?", "Sultan Murad 2", "Sultan Murad 1", "Sultan Murad 3","Sultan Murad 1","Sultan Murad 2",90);
        question3 = new QuizItem("Siapa Penakluk Andalusia?", "Thariq Bin Ziyad", "Thariq Bin Ziyad", "Utsman Bin Affan", "Nabi Muhammad", "Khalid Bin Walid?", 90);
        question4 = new QuizItem("Siapa Manusia Pertama?", "Adam", "Adam", "Nabi Muhammad", "Nabi Ibrahim", "Nabi Musa", 90);
        question5 = new QuizItem("Siapa Penakluk Yerusalem?", "Salahuddin Al-Ayyubi", "Salahuddin Al-Ayyubi", "Khalid Bin Walid", "Utsman Bin Affan", "Nabi Muhammad", 90);
        question6 = new QuizItem("Siapa Pembuat Tembok China?", "Kaisar Qin Shi Huang", "Kaisar Qin Shi Huang", "Kaisar Han Wudi", "Kaisar Han Wudi", "Kaisar Han Wudi", 90);
    }
}