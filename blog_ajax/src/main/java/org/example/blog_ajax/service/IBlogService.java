package org.example.blog_ajax.service;

import org.example.blog_ajax.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    List<Blog> findByCategory(Long id);

    List<Blog> search(String keyword);
}