package com.example.androidprojectcollection;

import static com.example.androidprojectcollection.MyCalculator.sequentialCalculate;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTV, solutionTV;
    Button btn_Addition, btn_Subtraction, btn_Multiplication, btn_Division;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    Button btn_Dot, btn_Equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_calculator);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_calculator_landscape);
        } else {
            setContentView(R.layout.activity_calculator);
        }

        resultTV = findViewById(R.id.result_tv);
        solutionTV = findViewById(R.id.solution_tv);

        assignId(btn_Addition, R.id.btnAdd);
        assignId(btn_Subtraction, R.id.btnSubtract);
        assignId(btn_Multiplication, R.id.btnMultiply);
        assignId(btn_Division, R.id.btnDivide);
        assignId(btn_0, R.id.btn0);
        assignId(btn_1, R.id.btn1);
        assignId(btn_2, R.id.btn2);
        assignId(btn_3, R.id.btn3);
        assignId(btn_4, R.id.btn4);
        assignId(btn_5, R.id.btn5);
        assignId(btn_6, R.id.btn6);
        assignId(btn_7, R.id.btn7);
        assignId(btn_8, R.id.btn8);
        assignId(btn_9, R.id.btn9);
        assignId(btn_Dot, R.id.btnDecimal);
        assignId(btn_Equals, R.id.btnEquals);

        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnAllClear = findViewById(R.id.btnAllClear);

        btnDelete.setOnClickListener(this);
        btnAllClear.setOnClickListener(this);


    }

    void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTV.getText().toString();
        boolean lastCharIsOperator = !dataToCalculate.isEmpty() && isOperator(dataToCalculate.charAt(dataToCalculate.length() - 1));

        switch (buttonText) {
            case "=":
                String result = MyCalculator.getResult(dataToCalculate);
                resultTV.setText(result);
                solutionTV.setText(result);
                break;
            case "AC":
                solutionTV.setText("");
                resultTV.setText("");
                break;
            case "DEL":
                if (dataToCalculate.length() > 0) {
                    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                    solutionTV.setText(dataToCalculate);
                }
                break;
            case ".":
                if (!dataToCalculate.isEmpty() && dataToCalculate.charAt(dataToCalculate.length() - 1) == '.') {
                    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                    solutionTV.setText(dataToCalculate);
                } else {
                    boolean hasDecimal = false;
                    for (int i = dataToCalculate.length() - 1; i >= 0; i--) {
                        char c = dataToCalculate.charAt(i);
                        if (!Character.isDigit(c) && c != '.') {
                            break;
                        }
                        if (c == '.') {
                            hasDecimal = true;
                            break;
                        }
                    }
                    if (!hasDecimal) {
                        dataToCalculate += buttonText;
                    }
                }
                solutionTV.setText(dataToCalculate);
                break;
            default:
                if (lastCharIsOperator && isOperator(buttonText.charAt(0)) && isOperator(buttonText)) {
                    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                }
                String temp = dataToCalculate;
                dataToCalculate += buttonText;
                solutionTV.setText(dataToCalculate);
                if(isOperator(buttonText)) {
                    String seqResult = MyCalculator.sequentialCalculate(temp);
                    resultTV.setText(seqResult);
                }
                break;
        }
    }

    private boolean isOperator(char c) {

        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*")||s.equals("/");
    }
}