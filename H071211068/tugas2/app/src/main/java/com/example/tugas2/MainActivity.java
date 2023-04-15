package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText result;
    Button btAC, btDel;
    Button btDiv, btMulti, btMin, btAdd, btEq;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    String Process,res;
    boolean operator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        b1 = findViewById(R.id.btn_1);
        b2 = findViewById(R.id.btn_2);
        b3 = findViewById(R.id.btn_3);
        b4 = findViewById(R.id.btn_4);
        b5 = findViewById(R.id.btn_5);
        b6 = findViewById(R.id.btn_6);
        b7 = findViewById(R.id.btn_7);
        b8 = findViewById(R.id.btn_8);
        b9 = findViewById(R.id.btn_9);
        b0 = findViewById(R.id.btn_0);

        btAC = findViewById(R.id.btn_ac);
        btDel = findViewById(R.id.btn_del);

        btDiv = findViewById(R.id.btn_div);
        btMulti = findViewById(R.id.btn_multi);
        btMin = findViewById(R.id.btn_min);
        btAdd = findViewById(R.id.btn_add);
        btEq = findViewById(R.id.btn_eq);

        Process = "";
        res = "";

        b0.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "0";
            displayOne();
        });

        b1.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "1";
            displayOne();
        });

        b2.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "2";
            displayOne();
        });

        b3.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "3";
            displayOne();
        });

        b4.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "4";
            displayOne();
        });

        b5.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "5";
            displayOne();
        });

        b6.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "6";
            displayOne();
        });

        b7.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "7";
            displayOne();
        });

        b8.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "8";
            displayOne();
        });

        b9.setOnClickListener(view -> {
            if (!res.isEmpty()){
                clear();
            }
            Process = Process + "9";
            displayOne();
        });

        btAdd.setOnClickListener(view -> {
            if (!operator){
                Process = Process + " + ";
                operator = true;
            }
            displayOne();
        });
        btMin.setOnClickListener(view -> {
            if (!operator){
                Process = Process + " - ";
                operator = true;
            }
            displayOne();
        });
        btMulti.setOnClickListener(view -> {
            if (!operator){
                Process = Process + " x ";
                operator = true;
            }
            displayOne();
        });
        btDiv.setOnClickListener(view -> {
            if (!operator){
                Process = Process + " / ";
                operator = true;
            }
            displayOne();
        });

        btDel.setOnClickListener(view -> {
            del();
            if (!res.isEmpty()) {
                res = res.substring(0, res.length() - 1);
                displayTwo();
            } else {
                displayOne();
            }
        });
        btEq.setOnClickListener(view -> {
            if (operator && Process.charAt(Process.length() - 1) != ' '){
                String [] tokens = Process.split(" ");
                switch (tokens[1].charAt(0)){
                    case '+':
                        res = Integer.toString((int) (Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2])));
                        break;
                    case '/':
                        res = Double.toString((Double) (Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2])));
                        break;
                    case 'x':
                        res = Integer.toString((int) (Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2])));
                        break;
                    case '-':
                        res = Integer.toString((int) (Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2])));
                        break;
                }
                displayTwo();
            }
        });
        btAC.setOnClickListener(view -> {
            clear();
            displayOne();
            displayTwo();
        });
    }
    public void del() {
        if (!Process.isEmpty()) {
            if (Process.charAt(Process.length() - 1) == ' ') {
                Process = Process.substring(0, Process.length() - 3);
                operator = false;
            } else  {
                Process = Process.substring(0, Process.length() - 1);
            }
        }
    }
    public void displayOne(){result.setText(Process);
    }
    public void displayTwo(){result.setText(res);
    }
    public void clear(){
        res = "";
        Process = "";
        operator = false;
    }

}