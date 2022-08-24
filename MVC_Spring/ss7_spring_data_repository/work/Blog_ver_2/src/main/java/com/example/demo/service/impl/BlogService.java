package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, String search, Category category) {
        Page<Blog> blogPage = null;
        if (category == null) {
            blogPage = iBlogRepository.findAllByDescriptionContaining(pageable, search);
        } else {
            blogPage = iBlogRepository.findAllByDescriptionContainingAndCategory(pageable, search, category);
        }
        return blogPage;
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }


}
