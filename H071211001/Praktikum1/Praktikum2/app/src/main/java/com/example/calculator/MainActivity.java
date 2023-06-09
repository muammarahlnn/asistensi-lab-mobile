package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnHapus, btnDelete, btnBagi, btn7, btn8, btn9, btnKali, btn4, btn5, btn6, btnKurang, btn1, btn2, btn3, btnTambah, btnNol, btnHasil;
    TextView inputAngka, outputAngka;
    private String input, output, newOutput;
    private View v;
    private String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNol = findViewById(R.id.btnNol);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnBagi = findViewById(R.id.btnBagi);
        btnKali = findViewById(R.id.btnKali);
        btnKurang = findViewById(R.id.btnKurang);
        btnTambah = findViewById(R.id.btnTambah);

        btnHapus = findViewById(R.id.btnHapus);
        btnHasil = findViewById(R.id.btnHasil);
        btnDelete = findViewById(R.id.btnDelete);

        inputAngka = findViewById(R.id.inputAngka);
        outputAngka = findViewById(R.id.outputAngka);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = inputAngka.getText().toString();
                int input = word.length();
                if (input > 0) {
                    inputAngka.setText(word.substring(0, input - 1));
                }
            }
        });
    }

    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = null;
                output = null;
                newOutput = null;
                outputAngka.setText("");
                break;

            case "*":
                solve();
                input += "*";
                break;

            case "=":
                solve();
                break;

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    solve();
                }
                input += data;
        }
        inputAngka.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputAngka.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputAngka.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputAngka.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputAngka.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputAngka.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputAngka.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputAngka.setText("-" + newOutput);
                    input = d + "";
                }else{
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputAngka.setText(newOutput);
                    input = d + "";
                }
            } catch (Exception e) {
                outputAngka.setError(e.getMessage().toString());
            }
        }
    }

    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }

}