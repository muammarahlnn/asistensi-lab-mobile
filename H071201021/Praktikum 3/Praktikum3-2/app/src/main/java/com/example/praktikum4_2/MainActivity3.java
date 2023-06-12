package com.example.praktikum4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import android.os.Handler;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    int level = 1;
    int score = 0;
    String[] soal = {"Siapa nama hokage kedua?", "Panggilan orang yang nonton anime?", "Apa yang terjadi ketika kamu di tabrak Truk?", "Artinya apa bang luffy?", "Bagian apa yang terlucu dari machine learning?"};

    ArrayList<String> soalList = new ArrayList<String>(Arrays.asList(soal));
    String[][] jawaban = {{"Yondaime", "Tobirama", "Soeharto", "Sarutobi", "2"},{"Wibu Bau Bawang", "Otaku", "Onion", "Wibu", "0"},{"Masuk Issekai", "Bertemu Waifu", "Tidak Ada", "Kamu Mati", "3"},{"Ente keeper terbaik sepanjang masa", "Ente wibu terbaik sepanjang masa", "Ente anime terbaik sepanjang masa", "Ente komedi terbaik sepanjang masa", "1"},{"Reinforcement Learning", "Supervised Learning", "SVM", "Unsupervised Learning", "2"}};
    List<List<String>> jawabanList = Arrays.stream(jawaban)
            .map(Arrays::asList)
            .collect(Collectors.toList());
    private Button[] optionButton = new Button[4];
    int randomNumber = (int) (Math.random() * soalList.size());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textViewSoal = findViewById(R.id.textViewSoal);
        TextView levelText = findViewById(R.id.textViewLevel);


        levelText.setText("Quiz " + level + " of 5");
        randomNumber = (int) (Math.random() * soalList.size());
        for (int j = 0; j < optionButton.length; j++) {
            String buttonID = "optionButton" + j;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            optionButton[j] = findViewById(resID);

//            optionButton[j].setText(jawabanList.get(randomNumber).get(j));
            optionButton[j].setOnClickListener(this);
        }
        nextLevel(randomNumber);
    }
    public void nextLevel(int randomNumber) {
        Intent i = getIntent();
        String currentHighScore = i.getStringExtra("currentHighScore");
        String stringUsername = i.getStringExtra("stringUsername");
        String profileImageUriString = i.getStringExtra("PROFILE_IMAGE_URI");
        if (level == 6) {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            if (score > Integer.parseInt(currentHighScore)) {
                currentHighScore = String.valueOf(score);
            }

            intent.putExtra("userScore", score);
            intent.putExtra("currentHighScore", currentHighScore);
            intent.putExtra("stringUsername", stringUsername);
            intent.putExtra("PROFILE_IMAGE_URI", profileImageUriString);
            startActivity(intent);
        }
        else {
            TextView levelText = findViewById(R.id.textViewLevel);
            TextView textViewSoal = findViewById(R.id.textViewSoal);
            levelText.setText("Quiz " + level + " of 5");
            Log.d("testis2", String.valueOf(randomNumber));

            textViewSoal.setText(soalList.get(randomNumber));

            for (int j = 0; j < optionButton.length; j++) {
                optionButton[j].setText(jawabanList.get(randomNumber).get(j));
            }
            soalList.remove(randomNumber);
        }
    }


    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Handler handler = new Handler();

        Toast toastWrong = Toast.makeText(context, "You are wrong!", duration);
        Toast toastCorrect = Toast.makeText(context, "correct!", duration);
        switch (v.getId()) {
            case R.id.optionButton0:
                for (int j = 0; j < optionButton.length; j++) {
                    optionButton[j].setEnabled(false);
                }

                if (jawabanList.get(randomNumber).get(4) == "0") {
                    optionButton[0].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    toastCorrect.show();
                    score += 100;
                }
                else {
                    optionButton[0].setBackgroundTintList(ColorStateList.valueOf(Color.RED));


                    toastWrong.show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        jawabanList.remove(randomNumber);
                        randomNumber = (int) (Math.random() * soalList.size());
                        level += 1;
                        nextLevel(randomNumber);
                        for (int j = 0; j < optionButton.length; j++) {
                            optionButton[j].setEnabled(true);
                            optionButton[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF6200EE")));


                        }

                    }
                }, 1000);

                break;
            case R.id.optionButton1:
                for (int j = 0; j < optionButton.length; j++) {
                    optionButton[j].setEnabled(false);
                }

                if (jawabanList.get(randomNumber).get(4) == "1") {
                    optionButton[1].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    toastCorrect.show();
                    score += 100;

                }
                else {
                    optionButton[1].setBackgroundTintList(ColorStateList.valueOf(Color.RED));


                    toastWrong.show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        jawabanList.remove(randomNumber);
                        randomNumber = (int) (Math.random() * soalList.size());
                        level += 1;
                        nextLevel(randomNumber);
                        for (int j = 0; j < optionButton.length; j++) {
                            optionButton[j].setEnabled(true);
                            optionButton[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF6200EE")));


                        }

                    }
                }, 1000);

                break;
            case R.id.optionButton2:
                for (int j = 0; j < optionButton.length; j++) {
                    optionButton[j].setEnabled(false);
                }

                if (jawabanList.get(randomNumber).get(4) == "2") {
                    optionButton[2].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));


                    toastCorrect.show();
                    score += 100;
                }
                else {
                    optionButton[2].setBackgroundTintList(ColorStateList.valueOf(Color.RED));


                    toastWrong.show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        jawabanList.remove(randomNumber);
                        randomNumber = (int) (Math.random() * soalList.size());
                        level += 1;
                        nextLevel(randomNumber);
                        for (int j = 0; j < optionButton.length; j++) {
                            optionButton[j].setEnabled(true);
                            optionButton[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF6200EE")));


                        }

                    }
                }, 1000);

                break;
            case R.id.optionButton3:
                for (int j = 0; j < optionButton.length; j++) {
                    optionButton[j].setEnabled(false);
                }

                if (jawabanList.get(randomNumber).get(4) == "3") {
                    optionButton[3].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    toastCorrect.show();
                    score += 100;
                }
                else {
                    optionButton[3].setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    toastWrong.show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        jawabanList.remove(randomNumber);
                        randomNumber = (int) (Math.random() * soalList.size());
                        level += 1;
                        nextLevel(randomNumber);
                        for (int j = 0; j < optionButton.length; j++) {
                            optionButton[j].setEnabled(true);
                            optionButton[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF6200EE")));

                        }

                    }
                }, 1000);

                break;
        }
    }
}