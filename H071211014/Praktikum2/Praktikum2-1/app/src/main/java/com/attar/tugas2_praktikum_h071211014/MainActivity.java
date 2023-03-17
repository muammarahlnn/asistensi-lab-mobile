package com.attar.tugas2_praktikum_h071211014;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.attar.tugas2_praktikum_h071211014.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String currentCalculation = "";

    String operator = "";

    boolean hasOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button0.setOnClickListener(view -> setCalculationText("0"));
        binding.button1.setOnClickListener(view -> setCalculationText("1"));
        binding.button2.setOnClickListener(view -> setCalculationText("2"));
        binding.button3.setOnClickListener(view -> setCalculationText("3"));
        binding.button4.setOnClickListener(view -> setCalculationText("4"));
        binding.button5.setOnClickListener(view -> setCalculationText("5"));
        binding.button6.setOnClickListener(view -> setCalculationText("6"));
        binding.button7.setOnClickListener(view -> setCalculationText("7"));
        binding.button8.setOnClickListener(view -> setCalculationText("8"));
        binding.button9.setOnClickListener(view -> setCalculationText("9"));
        binding.buttonPlus.setOnClickListener(view -> setOperation("+"));
        binding.buttonMinus.setOnClickListener(view -> setOperation("-"));
        binding.buttonMultiply.setOnClickListener(view -> setOperation("x"));
        binding.buttonDivide.setOnClickListener(view -> setOperation("/"));
        binding.buttonAc.setOnClickListener(view -> clearCalculation());
        binding.buttonDel.setOnClickListener(view -> delete());
        binding.buttonEquals.setOnClickListener(view -> performCalculation());
    }

    private void setCalculationText(String text){
        currentCalculation += text;
        binding.textViewResult.setText(currentCalculation);
    }

    private void setOperation(String operation){
        if (hasOperation){
            return;
        }
        operator = operation;
        currentCalculation += operation;
        binding.textViewResult.setText(currentCalculation);
        hasOperation = true;
    }

    private void clearCalculation(){
        hasOperation = false;
        currentCalculation = "";
        binding.textViewResult.setText(currentCalculation);
    }

    private void delete(){
        if (!currentCalculation.isEmpty()){
            char lastCalculation = currentCalculation.charAt(currentCalculation.length()-1);
            if (lastCalculation == '+' || lastCalculation == '-' || lastCalculation == 'x' || lastCalculation == '/'){
                hasOperation = false;
            }
            currentCalculation = currentCalculation.substring(0, currentCalculation.length()-1);
            binding.textViewResult.setText(currentCalculation);
        }
    }

    private void performCalculation(){
        String[] numbers=currentCalculation.split("[x\\+\\-\\/]");
        int number1 = Integer.parseInt(numbers[0]);
        int number2 = Integer.parseInt(numbers[1]);
        int result = 0;
        switch (operator){
            case "+":
                result = number1 + number2;
                currentCalculation = String.valueOf(result);
                binding.textViewResult.setText(String.valueOf(result));
                break;
            case "-":
                result = number1 - number2;
                currentCalculation = String.valueOf(result);
                binding.textViewResult.setText(String.valueOf(result));
                break;
            case "x":
                result = number1 * number2;
                currentCalculation = String.valueOf(result);
                binding.textViewResult.setText(String.valueOf(result));
                break;
            case "/":
                if (number2 == 0) {
                    Toast.makeText(this, "cannot divided by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = number1 / number2;
                currentCalculation = String.valueOf(result);
                binding.textViewResult.setText(String.valueOf(result));
                break;
        }
    }
}