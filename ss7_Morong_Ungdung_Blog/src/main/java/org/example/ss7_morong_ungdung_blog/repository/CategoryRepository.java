package org.example.ss7_morong_ungdung_blog.repository;

import org.example.ss7_morong_ungdung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category,Integer> {
}