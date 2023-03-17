package com.example.prak2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnEquel,
            btnTambah, btnKurang, btnKali, btnBagi, btnBackSpace, btnHapus;
    TextView angkaMasuk, angkaKeluar;
    String operator;
    String process;


    boolean hasOperation = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnEquel = findViewById(R.id.btnEquel);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnHapus = findViewById(R.id.btnHapus);

        angkaKeluar = findViewById(R.id.angkaKeluar);
        angkaMasuk = findViewById(R.id.angkaMasuk);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasOperation = false;
                angkaMasuk.setText("");
                angkaKeluar.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "9");
            }
        });
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasOperation) return;
                process = angkaMasuk.getText().toString();
                char c = process.charAt(process.length()-1);
                if (c == '+' || c == '-' || c == '×'|| c == '÷') {
                    process = process.substring(0, process.length()-1);
                }
                operator = "+";
                angkaMasuk.setText(process + "+");
                hasOperation = true;
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasOperation) return;
                process = angkaMasuk.getText().toString();
                char c = process.charAt(process.length()-1);
                if (c == '+' || c == '-' || c == '×'|| c == '÷') {
                    process = process.substring(0, process.length()-1);
                }
                operator = "-";
                angkaMasuk.setText(process + "-");
                hasOperation = true;
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasOperation) return;
                process = angkaMasuk.getText().toString();
                char c = process.charAt(process.length()-1);
                if (c == '+' || c == '-' || c == '×'|| c == '÷') {
                    process = process.substring(0, process.length()-1);
                }
                operator = "*";
                angkaMasuk.setText(process + "×");
                hasOperation = true;
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasOperation) return;
                process = angkaMasuk.getText().toString();
                char c = process.charAt(process.length()-1);
                if (c == '+' || c == '-' || c == '×'|| c == '÷') {
                    process = process.substring(0, process.length()-1);
                }
                operator = "/";
                angkaMasuk.setText(process + "÷");
                hasOperation = true;
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = angkaMasuk.getText().toString();
                int input = word.length();
                if(input>0){
                    char c = word.charAt(input-1);
                    if (c == '+' || c == '-' || c == '×'|| c == '÷') {
                        hasOperation = false;
                    }
                    angkaMasuk.setText(word.substring(0,input-1));
                }
            }
        });
        btnEquel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = angkaMasuk.getText().toString();
                process = process.replaceAll("×","*");
                process = process.replaceAll("÷","/");

                String[] arrayProcess  = process.split("[*+\\-/]");

                try {
                    if(operator.equals("+")){
                        int num1 = Integer.parseInt(arrayProcess[0]);
                        int num2 = Integer.parseInt(arrayProcess[1]);
                        angkaKeluar.setText(String.valueOf(num1 + num2));
                        angkaMasuk.setText("");
                        hasOperation = false;
                    } else if (operator.equals("-")) {
                        int num1 = Integer.parseInt(arrayProcess[0]);
                        int num2 = Integer.parseInt(arrayProcess[1]);
                        angkaKeluar.setText(String.valueOf(num1 - num2));
                        angkaMasuk.setText("");
                        hasOperation = false;
                    } else if (operator.equals("*")) {
                        int num1 = Integer.parseInt(arrayProcess[0]);
                        int num2 = Integer.parseInt(arrayProcess[1]);
                        angkaKeluar.setText(String.valueOf(num1 * num2));
                        angkaMasuk.setText("");
                        hasOperation = false;
                    } else if (operator.equals("/")) {
                        double num1 = Double.parseDouble(arrayProcess[0]);
                        double num2 = Double.parseDouble(arrayProcess[1]);
                        angkaKeluar.setText(String.valueOf(num1 / num2));
                        angkaMasuk.setText("");
                        hasOperation = false;
                    }
                }
                catch (NumberFormatException ex) {
                    Toast.makeText(getApplicationContext(), "Angka terlalu banyak", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private char getLastProcess() {
        return process.charAt(process.length()-1);
    }
}