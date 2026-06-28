package org.example.blog_ajax.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog_ajax.model.Blog;
import org.example.blog_ajax.service.IBlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogRestController {

    private final IBlogService blogService;

    @GetMapping
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable Long id) {
        return blogService.findById(id)
                .orElseThrow();
    }

    @GetMapping("/search")
    public List<Blog> search(
            @RequestParam String keyword) {

        return blogService.search(keyword);
    }

    @GetMapping("/category/{id}")
    public List<Blog> findByCategory(
            @PathVariable Long id) {

        return blogService.findByCategory(id);
    }
}