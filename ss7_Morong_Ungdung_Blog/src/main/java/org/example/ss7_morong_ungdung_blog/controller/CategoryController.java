package org.example.ss7_morong_ungdung_blog.controller;

import org.example.ss7_morong_ungdung_blog.model.Category;
import org.example.ss7_morong_ungdung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(Model model) {

        model.addAttribute(
                "categories",
                categoryService.findAll());

        return "category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {

        model.addAttribute(
                "category",
                new Category());

        return "category/create";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "category",
                categoryService.findById(id));

        return "category/edit";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Integer id) {

        categoryService.delete(id);

        return "redirect:/categories";
    }
}