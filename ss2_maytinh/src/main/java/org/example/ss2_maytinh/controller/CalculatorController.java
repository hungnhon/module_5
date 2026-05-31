package org.example.ss2_maytinh.controller;

import org.example.ss2_maytinh.service.CalculatorService;
import org.example.ss2_maytinh.service.ICalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final ICalculatorService calculatorService =
            new CalculatorService();

    @GetMapping({"/", "/calculator"})
    public String show() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("action") String action,
            Model model) {

        String result =
                calculatorService.execute(action, num1, num2);

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);

        return "index";
    }
}