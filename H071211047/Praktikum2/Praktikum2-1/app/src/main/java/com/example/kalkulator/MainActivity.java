package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView hasil, solution;
    String operator = "";
    int hasilakhir = 0;
    double hasilbagi = 0;
//    boolean titiknol = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasil=findViewById(R.id.hasil);
        solution=findViewById(R.id.solution);
    }

   public void delete (View view) {
       String data = hasil.getText().toString();
//       titiknol = true;
       char lastChar = data.charAt(data.length()-1);
       if (lastChar == '+' || lastChar == '-' || lastChar == 'x' || lastChar == '/') {
           operator = "";
       }
       if (data.length() == 1){
           data = "0";
           hasil.setText(data);
       } else {
           if (data.length() !=0) {
               data = data.substring(0, data.length()-1);
               hasil.setText(data);
           }
       }
   }

   public void clear(View view) {
        operator = "";
        hasil.setText("0");
//        titiknol = true;
   }

   public void perhitungan(View view) {
        if (operator.isEmpty() == false) {
            return;
        }
       switch(view.getId()) {
           case R.id.btn_tambah:
               operator = "+";
               break;
           case R.id.btn_kurang:
               operator = "-";
               break;

           case R.id.btn_kali:
               operator = "x";
               break;

           case R.id.btn_divide:
               operator = "/" ;
               break;
       }
       hasil.setText(hasil.getText().toString() + operator);
   }

   public void bilangan (View view){
//       if (titiknol) {
//           hasil.setText("");
//           titiknol = false;
//       }
       if (hasil.getText().toString().equals("0")) {
           hasil.setText("");
       }
       String angka = hasil.getText().toString();
       switch(view.getId()) {
           case R.id.btn_nol:
                angka += "0";
                break;
           case R.id.btn_1:
               angka += "1";
               break;
           case R.id.btn_2:
               angka += "2";
               break;
           case R.id.btn_3:
                angka += "3";
                break;
           case R.id.btn_4:
               angka += "4";
               break;
           case R.id.btn_5:
               angka += "5";
               break;
           case R.id.btn_6:
               angka += "6";
               break;
           case R.id.btn_7:
               angka += "7";
               break;
           case R.id.btn_8:
               angka += "8";
               break;
           case R.id.btn_9:
               angka += "9";
               break;
       }
       hasil.setText(angka);
   }

   public void hasilop (View view) {
        String[] data = hasil.getText().toString().split("[x\\+\\-\\/]");
//        titiknol = false;
        int number1 = Integer.parseInt(data[0]);
        int number2 = Integer.parseInt(data[1]);
        switch (operator) {
            case "+":
                hasilakhir = number1 + number2;
                hasil.setText(String.valueOf(hasilakhir));
                operator = "";
                break;
            case "-":
                hasilakhir = number1 - number2;
                hasil.setText(String.valueOf(hasilakhir));
                operator = "";
                break;
            case "x":
                hasilakhir = number1 * number2;
                hasil.setText(String.valueOf(hasilakhir));
                operator = "";
                break;
            case "/":
                if (number2 == 0) {
                    Toast.makeText(this, "tidak bisa dibagi 0", Toast.LENGTH_SHORT).show();
                } else {
                    hasilbagi = number1 / number2;
                    hasil.setText(String.valueOf(hasilbagi));
                    break;
                }
        }
   }


}