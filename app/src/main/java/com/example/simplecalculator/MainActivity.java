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
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);
//        findViewById(R.id.equals).setOnClickListener(MainActivity.this);
        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
                int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());
                int operatorButtonId = operators.getCheckedRadioButtonId();
                Integer answer;
                if(operatorButtonId == add.getId()){
                    answer = firstNumberValue + secondNumberValue;
                } else {
                    answer = firstNumberValue - secondNumberValue;
                }
                result.setText(answer.toString());
            }
        });

        }
/*        @Override
        public void onClick(View v) {
            int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
            int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());
    }*/

}