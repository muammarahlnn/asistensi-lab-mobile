package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnMultipply,btnDivide,btnPlus,btnMinus,btnClear,btnDelete,btnEqual;
    private TextView result,info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        info = findViewById(R.id.userInput);
        btnMultipply = findViewById(R.id.btn_multiplication);
        btnDivide = findViewById(R.id.btn_divide);
        btnClear = findViewById(R.id.btn_clear);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDelete = findViewById(R.id.btn_del);
        btnEqual = findViewById(R.id.btn_result);




        btnPlus.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "+");
        });
        btnMinus.setOnClickListener(v ->{
            info.setText(info.getText().toString() + "-");
        });
        btnDivide.setOnClickListener(v ->{
            info.setText(info.getText().toString() + "/");
        });
        btnMultipply.setOnClickListener(v ->{
            info.setText(info.getText().toString() + "X");
        });
        btn0.setOnClickListener(v -> {
            if(info.getText().toString().equals("0")){
                return;
            }
            info.setText(info.getText().toString() + "0");
        });
        btn1.setOnClickListener(v -> {
            //set text to 1
            info.setText("1");
            info.getText().toString();
        });
        btn2.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "2");
        });
        btn3.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "3");
        });
        btn4.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "4");
        });
        btn5.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "5");
        });
        btn6.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "6");
        });
        btn7.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "7");
        });
        btn8.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "8");
        });
        btn9.setOnClickListener(v -> {
            info.setText(info.getText().toString() + "9");
        });
        btnClear.setOnClickListener(v -> {
            info.setText("");
        });

        info.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                //Jika sudah melakukan pengoperasian satu kali maka tidak bisa melakukan pengoperasian
                if (s.toString().contains("+") || s.toString().contains("-") || s.toString().contains("X") || s.toString().contains("/")){
                    btnPlus.setEnabled(false);
                    btnMinus.setEnabled(false);
                    btnMultipply.setEnabled(false);
                    btnDivide.setEnabled(false);
                }
                else {
                    btnPlus.setEnabled(true);
                    btnMinus.setEnabled(true);
                    btnMultipply.setEnabled(true);
                    btnDivide.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnDelete.setOnClickListener(v -> {
            String str   = info.getText().toString();
            if (str.length() > 0){
                str = str.substring(0,str.length()-1);
                info.setText(str);
            }
            else {
                info.setText("");
            }
        });

        btnEqual.setOnClickListener(v -> {
            String str = info.getText().toString();
            if (str.contains("X")){
                String[] numbers = str.split("X");
                 try {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    info.setText(String.valueOf(num1 * num2));
                }
                catch (Exception e){
                    info.setText("Error");
                }
            }
            else if (str.contains("/")){
                String[] numbers = str.split("/");
                try {
                    double num1 = Double.parseDouble(numbers[0]);
                    double num2 = Double.parseDouble(numbers[1]);
                    info.setText(String.valueOf(num1 / num2));
                }
                catch (Exception e){
                    info.setText("Error");
                }
            }
            else if (str.contains("+")){
                String[] numbers = str.split("\\+");
                try {
                    double num1 = Double.parseDouble(numbers[0]);
                    double num2 = Double.parseDouble(numbers[1]);
                    info.setText(String.valueOf(num1 + num2));
                }
                catch (Exception e){
                    info.setText("Error");
                }
            }
            else if (str.contains("-")){
                String[] numbers = str.split("-");
                try {
                    double num1 = Double.parseDouble(numbers[0]);
                    double num2 = Double.parseDouble(numbers[1]);
                    info.setText(String.valueOf(num1 - num2));
                }
                catch (Exception e){
                    info.setText("Error");
                }
            }
            else {
                info.setText("Error");
            }
        });


    }
}