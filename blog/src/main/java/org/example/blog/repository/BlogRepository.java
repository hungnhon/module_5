package org.example.blog.repository;

import org.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository
        extends JpaRepository<Blog, Long> {

    List<Blog> findByCategoryId(Long id);
}