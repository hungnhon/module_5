package org.example.blog_ajax.repository;

import org.example.blog_ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}