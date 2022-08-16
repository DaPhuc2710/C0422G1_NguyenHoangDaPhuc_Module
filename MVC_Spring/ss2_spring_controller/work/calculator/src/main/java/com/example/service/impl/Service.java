package com.example.service.impl;

import com.example.service.IService;
@org.springframework.stereotype.Service
public class Service implements IService {
    @Override
    public String calculate(String num1, String num2, String operator) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(number1 + number2);
                break;
            case "-":
                result = String.valueOf(number1 - number2);
                break;
            case "*":
                result = String.valueOf(number1 * number2);
                break;
            case "/":
                if (number2 == 0) {
                    return "Can not divide by zero";
                } else {
                    result = String.valueOf(number1 / number2);
                }
                break;
        }
        return result;
    }
}
