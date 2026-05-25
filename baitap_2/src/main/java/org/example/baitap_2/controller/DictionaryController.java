package org.example.baitap_2.controller;

import org.example.baitap_2.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/")
    public String showForm() {

        return "index";

    }

    @RequestMapping("search")
    public String search(

            @RequestParam("word") String word,
            Model model) {

        String result = dictionaryService.search(word);

        if (result == null) {

            result = "Không tìm thấy";

        }

        model.addAttribute("word", word);

        model.addAttribute("result", result);

        return "index";
    }
}