package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText firstNumber = findViewById(R.id.number1);
        EditText secondNumber = findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.operators);
        RadioButton add = findViewById(R.id.add);
        RadioButton subtract = findViewById(R.id.subtract);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);
//        findViewById(R.id.equals).setOnClickListener(MainActivity.this);
        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double firstNumberValue = 0.0;
                Double secondNumberValue = 0.0;

/*                if ((Double.parseDouble(firstNumber.getText().toString())) >= 0 || ((Double.parseDouble(firstNumber.getText().toString())) < 0)) {
                    firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
                } else {
                    firstNumberValue = 0.0;
                }

                if ((Double.parseDouble(secondNumber.getText().toString())) >= 0 || ((Double.parseDouble(secondNumber.getText().toString())) < 0)) {
                    secondNumberValue = Double.parseDouble(secondNumber.getText().toString());
                } else {
                    secondNumberValue = 0.0;
                }*/

try {
    firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
} catch (Exception e) {

                }

                try {
                    secondNumberValue = Double.parseDouble(secondNumber.getText().toString());
                } catch (Exception e) {

                }

                int operatorButtonId = operators.getCheckedRadioButtonId();
                Double answer = 0.0;

                if ((secondNumberValue >= 0) && (firstNumberValue >= 0)) {

                    if (operatorButtonId == add.getId()) {
                        answer = firstNumberValue + secondNumberValue;
                    } else if (operatorButtonId == subtract.getId()) {
                        answer = firstNumberValue - secondNumberValue;
                    } else if (operatorButtonId == multiply.getId()) {
                        answer = firstNumberValue * secondNumberValue;
                    } else if ((operatorButtonId == divide.getId()) && (secondNumberValue != 0)) {
                        answer = firstNumberValue / secondNumberValue;
                    }

                    result.setText(answer.toString());

                } else if ((operatorButtonId == divide.getId()) && (secondNumberValue == 0)) {
                    secondNumber.setText("Cannot divide by zero");
                } else if ((firstNumberValue >= 0) == false) {
                    firstNumber.setText("You must place a number here");
                } else if ((secondNumberValue >= 0) == false){
                    secondNumber.setText("You must place a number here");
                } else {
                    result.setText("User input not valid");
                }

            }
        });
    }
/*        @Override
        public void onClick(View v) {
            int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
            int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());
    }*/

}