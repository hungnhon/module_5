package org.example.ss2_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("save")
    public String save(
            @RequestParam(value = "condiment", required = false)
            String[] condiment,
            Model model) {

        model.addAttribute("selectedCondiment", condiment);

        return "result";
    }
}