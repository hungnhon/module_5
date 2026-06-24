package org.example.blog.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog.model.Category;
import org.example.blog.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController {

    private final ICategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}