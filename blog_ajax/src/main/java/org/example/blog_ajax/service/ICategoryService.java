package org.example.blog_ajax.service;

import org.example.blog_ajax.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
}