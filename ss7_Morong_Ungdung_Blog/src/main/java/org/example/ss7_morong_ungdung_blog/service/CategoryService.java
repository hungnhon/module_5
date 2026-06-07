package org.example.ss7_morong_ungdung_blog.service;

import org.example.ss7_morong_ungdung_blog.model.Category;
import org.example.ss7_morong_ungdung_blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
        implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}