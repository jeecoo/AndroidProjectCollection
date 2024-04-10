package com.example.androidprojectcollection;

import java.util.ArrayList;
import java.util.Stack;

public class MyCalculator {
    public static String getResult(String expression) {
        try {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == ' ')
                    continue;
                if (Character.isDigit(c) || c == '.') {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i++));
                    }
                    i--;
                    numbers.push(Double.parseDouble(sb.toString()));
                } else if (c == '*' || c == '/') {
                    while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                        numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(c);
                } else if (c == '+' || c == '-') {
                    while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/' || operators.peek() == '+' || operators.peek() == '-')) {
                        numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(c);
                }
            }
            while (!operators.isEmpty()) {
                numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
            }
            return Double.toString(numbers.pop());
        } catch (Exception e) {
            return "Error";
        }
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0)
                    return a / b;
                else
                    throw new ArithmeticException("Error");
        }
        return 0;
    }

    public static String sequentialCalculate(String data) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    numbers.push(Double.parseDouble(temp.toString()));
                    temp.setLength(0);
                }
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(applyOperator(op, a, b));
                }
                operators.push(c);
            }
        }
        if (temp.length() > 0) {
            numbers.push(Double.parseDouble(temp.toString()));
        }
        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operators.pop();
            numbers.push(applyOperator(op, a, b));
        }
        return Double.toString(numbers.pop());
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }


    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }



}

