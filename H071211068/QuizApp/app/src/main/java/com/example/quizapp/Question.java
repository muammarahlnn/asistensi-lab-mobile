package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

public class Question extends AppCompatActivity {

    public static String[] question = {
            "2x + 3x - 5x",
            "Universitas Terbaik Di Indonesia Timur?",
            "Siapa Presiden Rusia Saat Ini?",
            "Mengapa Amerika Suka Membantu Negara Lain",
            "Klub Terbaik Di Dunia"
    };

    public static String[][] choices = {
            {"0", "x", "2x", "3x"},
            {"Universitas Sam Ratulangi", "Universitas Hasanuddin", "Universitas Gadjah Mada", "Universitas Cendrawasih"},
            {"Adolf Hitler", "Joseph Stalin", "Vladimir Lenin", "Vladimir Putin"},
            {"Untuk Membantu Negara Lain", "MINYAK!!", "Persahabatan", "Gabut"},
            {"Inter Milan", "Frankfurt", "Real Madrid", "Viktoria Plzen"}
    };

    public static String[] Answers = {
            "0",
            "Universitas Hasanuddin",
            "Vladimir Putin",
            "MINYAK!!",
            "Real Madrid"
    };
}



