package org.example.ss7_morong_ungdung_blog.service;

import org.example.ss7_morong_ungdung_blog.model.Blog;
import org.example.ss7_morong_ungdung_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository repository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> search(String keyword,
                             Pageable pageable) {

        return repository.findByTitleContaining(
                keyword,
                pageable);
    }

    @Override
    public Page<Blog> findByCategory(Integer categoryId,
                                     Pageable pageable) {

        return repository.findByCategoryId(
                categoryId,
                pageable);
    }
}