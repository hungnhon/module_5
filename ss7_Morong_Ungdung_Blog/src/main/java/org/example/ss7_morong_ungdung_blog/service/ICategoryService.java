package org.example.ss7_morong_ungdung_blog.service;

import org.example.ss7_morong_ungdung_blog.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void delete(Integer id);
}