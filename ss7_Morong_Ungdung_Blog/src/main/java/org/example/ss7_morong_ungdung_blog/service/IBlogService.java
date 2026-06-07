package org.example.ss7_morong_ungdung_blog.service;

import org.example.ss7_morong_ungdung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    Page<Blog> search(
            String keyword,
            Pageable pageable);

    Page<Blog> findByCategory(
            Integer categoryId,
            Pageable pageable);
}