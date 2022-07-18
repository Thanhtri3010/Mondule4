package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String check(int number1, int number2, String operator) {
        if (number2 == 0) {
            return "Can not Divide by Zero";
        } else {
            return String.valueOf(doCalculate(number1, number2, operator));
        }
    }

    @Override
    public double doCalculate(int number1, int number2, String operator) {
        double result = 0;
        switch (operator) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiple":
                result = number1 * number2;
                break;
            case "divide":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
