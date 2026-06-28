package org.example.blog_ajax.service;

import lombok.RequiredArgsConstructor;
import org.example.blog_ajax.model.Category;
import org.example.blog_ajax.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService
        implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}