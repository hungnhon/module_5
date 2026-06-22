package org.example.shoppingcart.controller;

import lombok.RequiredArgsConstructor;
import org.example.shoppingcart.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showProductList(Model model) {

        model.addAttribute("products",
                productService.findAll());

        return "product/list";
    }

    @GetMapping("/products/{id}")
    public String showProductDetail(@PathVariable Long id,
                                    Model model) {

        model.addAttribute("product",
                productService.findById(id).orElseThrow());

        return "product/detail";
    }
}