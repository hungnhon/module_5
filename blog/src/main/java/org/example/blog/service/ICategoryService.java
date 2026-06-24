package org.example.blog.service;

import org.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
}