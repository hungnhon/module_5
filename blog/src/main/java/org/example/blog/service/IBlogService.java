package org.example.blog.service;

import org.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    List<Blog> findByCategory(Long id);
}
