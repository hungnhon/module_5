package org.example.ss7_morong_ungdung_blog.repository;

import org.example.ss7_morong_ungdung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository
        extends JpaRepository<Blog,Integer> {

    Page<Blog> findByTitleContaining(
            String keyword,
            Pageable pageable);

    Page<Blog> findByCategoryId(
            Integer categoryId,
            Pageable pageable);
}