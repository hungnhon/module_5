package org.example.blog_ajax.repository;

import org.example.blog_ajax.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository
        extends JpaRepository<Blog, Long> {

    List<Blog> findByCategoryId(Long id);

    List<Blog> findByTitleContaining(String keyword);
}