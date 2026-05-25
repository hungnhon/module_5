package org.example.demo_bt1.controller;

import org.example.demo_bt1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping("/")
    public String showForm() {

        return "index";

    }

    @RequestMapping("/convert")
    public String convert(

            @RequestParam("usd") double usd,
            @RequestParam("rate") double rate,
            Model model) {

        double vnd = currencyService.convert(usd, rate);

        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", vnd);

        return "index";
    }
}