    package com.example.praktikum2_1;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.AppCompatButton;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        TextView result, solution;
        AppCompatButton buttonC;
        AppCompatButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals, buttonModulo;
        AppCompatButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
        AppCompatButton buttonAC, buttonDot;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            result = findViewById(R.id.result);
            solution = findViewById(R.id.solution);

            assignId(buttonC,R.id.buttonC);
            assignId(buttonModulo,R.id.buttonModulo);
            assignId(buttonDivide,R.id.buttonDivide);
            assignId(buttonMultiply,R.id.buttonMultiply);
            assignId(buttonPlus,R.id.buttonPlus);
            assignId(buttonMinus,R.id.buttonMinus);
            assignId(buttonEquals,R.id.buttonEquals);
            assignId(button0,R.id.button0);
            assignId(button1,R.id.button1);
            assignId(button2,R.id.button2);
            assignId(button3,R.id.button3);
            assignId(button4,R.id.button4);
            assignId(button5,R.id.button5);
            assignId(button6,R.id.button6);
            assignId(button7,R.id.button7);
            assignId(button8,R.id.button8);
            assignId(button9,R.id.button9);
            assignId(buttonAC,R.id.buttonAC);
            assignId(buttonDot,R.id.buttonDot);

        }

        void assignId(AppCompatButton btn, int id) {
            btn = findViewById(id);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AppCompatButton button =(AppCompatButton) view;
            String buttonText = button.getText().toString();
            String dataToCalculate = solution.getText().toString();

            if (buttonText.equals("AC")) {
                solution.setText("");
                result.setText("");
                return;
            }

            if (buttonText.equals("=")) {
                getResult();
                return;
            }

            if(buttonText.equals("C")) {
                if(dataToCalculate.length() > 0) {
                    StringBuilder sb = new StringBuilder(solution.getText());
                    sb.deleteCharAt(solution.getText().length()-1);
                    dataToCalculate = sb.toString();
                    solution.setText(dataToCalculate);
                }
                return;
            }

            if (buttonText.equals("C")){
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }

            if (buttonText.equals("mod") || buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                if (dataToCalculate.contains("mod") || dataToCalculate.contains("+") || dataToCalculate.contains("-") || dataToCalculate.contains("/") || dataToCalculate.contains("*")) {
                    dataToCalculate = dataToCalculate.replace("mod", buttonText).replace("+", buttonText).replace("-", buttonText).replace("*", buttonText).replace("/", buttonText);
                }else {
                    dataToCalculate = dataToCalculate+buttonText;
                }
            }else {
                dataToCalculate = dataToCalculate+buttonText;
            }

            solution.setText(dataToCalculate);
        }

        public void getResult() {
            String data = solution.getText().toString();
            char lastChar = data.charAt(data.length() - 1);
            if (lastChar == '*' || lastChar == '/' || lastChar == '+' || lastChar == '-' || lastChar == 'd') {
                return;
            }
            data = data.replace("mod", "%");
            String[] calculation = data.split("[%/*+-]");

            if (data.contains("/")) {
                Double op1 = Double.parseDouble(calculation[0]);
                Double op2 = Double.parseDouble(calculation[1]);
                double finalResult = op1 / op2;
                if (finalResult % 1 == 0) {
                    result.setText(String.format("%.0f", finalResult));
                } else {
                    result.setText(String.format("%.2f", finalResult));
                }
            }else if (data.contains("*")) {
                Double op1 = Double.parseDouble(calculation[0]);
                Double op2 = Double.parseDouble(calculation[1]);
                double finalResult = op1 * op2;
                if (finalResult % 1 == 0) {
                    result.setText(String.format("%.0f", finalResult));
                } else {
                    result.setText(String.format("%.2f", finalResult));
                }
            }else if (data.contains("+")) {
                Double op1 = Double.parseDouble(calculation[0]);
                Double op2 = Double.parseDouble(calculation[1]);
                double finalResult = op1 + op2;
                if (finalResult % 1 == 0) {
                    result.setText(String.format("%.0f", finalResult));
                } else {
                    result.setText(String.format("%.2f", finalResult));
                }
            }else if (data.contains("-")){
                Double op1 = Double.parseDouble(calculation[0]);
                Double op2 = Double.parseDouble(calculation[1]);
                double finalResult = op1 - op2;
                if (finalResult % 1 == 0) {
                    result.setText(String.format("%.0f", finalResult));
                } else {
                    result.setText(String.format("%.2f", finalResult));
                }
            }else {
                Double op1 = Double.parseDouble(calculation[0]);
                Double op2 = Double.parseDouble(calculation[1]);
                double finalResult = op1 % op2;
                if (finalResult % 1 == 0) {
                    result.setText(String.format("%.0f", finalResult));
                } else {
                    result.setText(String.format("%.2f", finalResult));
                }
            }
        }
    }