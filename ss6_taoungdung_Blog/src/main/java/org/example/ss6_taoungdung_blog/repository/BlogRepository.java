package org.example.ss6_taoungdung_blog.repository;

import org.example.ss6_taoungdung_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository
        extends JpaRepository<Blog,Integer> {
}