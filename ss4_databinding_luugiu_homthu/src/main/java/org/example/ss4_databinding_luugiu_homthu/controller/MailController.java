package org.example.ss4_databinding_luugiu_homthu.controller;

import org.example.ss4_databinding_luugiu_homthu.model.MailSetting;
import org.example.ss4_databinding_luugiu_homthu.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @Autowired
    private IMailService mailService;

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute(
                "mailSetting",
                mailService.getSetting()
        );

        model.addAttribute(
                "languages",
                new String[]{
                        "English",
                        "Vietnamese",
                        "Japanese",
                        "Chinese"
                }
        );

        model.addAttribute(
                "pageSizes",
                new Integer[]{
                        5, 10, 15, 25, 50, 100
                }
        );

        return "setting";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute MailSetting mailSetting,
            Model model) {

        mailService.update(mailSetting);

        model.addAttribute(
                "mailSetting",
                mailSetting
        );

        return "result";
    }
}