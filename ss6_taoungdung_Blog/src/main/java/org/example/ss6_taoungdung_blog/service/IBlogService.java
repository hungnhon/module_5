package org.example.ss6_taoungdung_blog.service;

import org.example.ss6_taoungdung_blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);
}