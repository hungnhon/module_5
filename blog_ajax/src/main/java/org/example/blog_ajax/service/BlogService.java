package org.example.blog_ajax.service;

import lombok.RequiredArgsConstructor;
import org.example.blog_ajax.model.Blog;
import org.example.blog_ajax.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService {

    private final BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByCategory(Long id) {
        return blogRepository.findByCategoryId(id);
    }

    @Override
    public List<Blog> search(String keyword) {
        return blogRepository.findByTitleContaining(keyword);
    }
}