package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private Button clearButton, divideButton, multiplyButton, minusButton, plusButton, equalButton, deleteButton;
    private Button[] digitButtons = new Button[10];
    private boolean signActive = false;
    private boolean calculateFinish = true;
    boolean add, sub, mul, div;

    private String[] arrayString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        clearButton = findViewById(R.id.clearButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);
        equalButton = findViewById(R.id.equalButton);
        deleteButton = findViewById(R.id.deleteButton);

        for (int i = 0; i < digitButtons.length; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            digitButtons[i] = findViewById(resID);
            digitButtons[i].setOnClickListener(this);
        }

        clearButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

    }
    public void addNumber(String number) {
        if (resultTextView.getText().toString().equals("0")) {
            resultTextView.setText(number);
        }
        else {
            resultTextView.setText(resultTextView.getText().toString() + number);
        }
        signActive = false;
    }

    public void addSign(String sign) {
        if (!signActive && !resultTextView.getText().toString().equals("0") && calculateFinish) {
            resultTextView.setText(resultTextView.getText().toString() + sign);
            signActive = true;
            calculateFinish = false;
        }
    }

    public void calculateEquation(String operatorButton) {
        //  Block of code to try
        arrayString = resultTextView.getText().toString().split("\\" + operatorButton);
        double result = performOperation(operatorButton, Double.parseDouble(arrayString[0]), Double.parseDouble(arrayString[1]));
        resultTextView.setText(String.valueOf(result));
    }

    private double performOperation(String currentOperator, double firstNumber, double secondNumber) {
        switch (currentOperator) {
            case "+":
                return firstNumber + secondNumber;

            case "-":
                return firstNumber - secondNumber;

            case "*":
                return firstNumber * secondNumber;

            case "/":
                return firstNumber / secondNumber;

            default:
                return 0;
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.clearButton:
                // Clear the result
                resultTextView.setText("0");
                signActive = false;
                calculateFinish = true;
                add = false;
                sub = false;
                mul = false;
                div = false;
                break;

            case R.id.deleteButton:
                if (!signActive && !resultTextView.getText().toString().equals("0")) {
                    resultTextView.setText(resultTextView.getText().toString().replaceFirst(".$", ""));
                    Pattern pattern =  Pattern.compile("[/*+-]", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(resultTextView.getText().toString());
                    if (!matcher.find()) {
                        signActive = false;
                        calculateFinish = true;
                        add = false;
                        sub = false;
                        mul = false;
                        div = false;
                    }
                }
                break;

            case R.id.equalButton:
                if (!signActive && !calculateFinish) {
                    if (add) {
                        calculateEquation("+");
                        add = false;
                    }

                    if (sub) {
                        calculateEquation("-");
                        sub = false;
                    }

                    if (mul) {
                        calculateEquation("*");
                        mul = false;
                    }

                    if (div) {
                        calculateEquation("/");
                        div = false;
                    }
                    calculateFinish = true;
                }
                break;

            case R.id.divideButton:
                if (!signActive) {
                    addSign("/");
                    div = true;
                }
                break;

            case R.id.multiplyButton:
                if (!signActive) {
                    addSign("*");
                    mul = true;
                }
                break;

            case R.id.minusButton:
                if (!signActive) {
                    try {
                        if (!(Double.parseDouble(resultTextView.getText().toString()) < 0)) {
                            addSign("-");
                            sub = true;
                        }
                    }
                    catch(Exception e) {
                    }
                }
                break;

            case R.id.plusButton:
                if (!signActive) {
                    addSign("+");
                    add = true;
                }
                break;

            case R.id.button0:
                addNumber("0");
                break;
            case R.id.button1:
                addNumber("1");
                break;
            case R.id.button2:
                addNumber("2");
                break;
            case R.id.button3:
                addNumber("3");
                break;
            case R.id.button4:
                addNumber("4");
                break;
            case R.id.button5:
                addNumber("5");
                break;
            case R.id.button6:
                addNumber("6");
                break;
            case R.id.button7:
                addNumber("7");
                break;
            case R.id.button8:
                addNumber("8");
                break;
            case R.id.button9:
                addNumber("9");
                break;
        }
    }
}
