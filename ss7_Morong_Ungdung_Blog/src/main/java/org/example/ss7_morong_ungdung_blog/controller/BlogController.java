package org.example.ss7_morong_ungdung_blog.controller;

import org.example.ss7_morong_ungdung_blog.model.Blog;
import org.example.ss7_morong_ungdung_blog.service.IBlogService;
import org.example.ss7_morong_ungdung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        5,
                        Sort.by("id").descending());

        Page<Blog> blogs;

        if (keyword.isEmpty()) {
            blogs = blogService.findAll(pageable);
        } else {
            blogs = blogService.search(keyword, pageable);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories",
                categoryService.findAll());

        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {

        model.addAttribute(
                "blog",
                new Blog());

        model.addAttribute(
                "categories",
                categoryService.findAll());

        return "blog/create";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute Blog blog) {

        blogService.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "blog",
                blogService.findById(id));

        return "blog/view";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "blog",
                blogService.findById(id));

        model.addAttribute(
                "categories",
                categoryService.findAll());

        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute Blog blog) {

        blogService.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Integer id) {

        blogService.delete(id);

        return "redirect:/blogs";
    }

    @GetMapping("/category/{id}")
    public String blogByCategory(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable =
                PageRequest.of(page, 5);

        model.addAttribute(
                "blogs",
                blogService.findByCategory(
                        id,
                        pageable));

        model.addAttribute(
                "categories",
                categoryService.findAll());

        return "blog/list";
    }
}