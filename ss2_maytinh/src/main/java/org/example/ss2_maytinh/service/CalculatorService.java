package org.example.ss2_maytinh.service;
import org.example.ss2_maytinh.service.ICalculatorService;

public class CalculatorService implements ICalculatorService {

    @Override
    public String execute(String action, double num1, double num2) {

        double result;

        switch (action) {
            case "add":
                result = num1 + num2;
                return num1 + " + " + num2 + " = " + result;

            case "sub":
                result = num1 - num2;
                return num1 + " - " + num2 + " = " + result;

            case "mul":
                result = num1 * num2;
                return num1 + " * " + num2 + " = " + result;

            case "div":
                if (num2 == 0) {
                    return "Lỗi: Không thể chia cho 0!";
                }
                result = num1 / num2;
                return num1 + " / " + num2 + " = " + result;

            default:
                return "Phép tính không hợp lệ!";
        }
    }
}