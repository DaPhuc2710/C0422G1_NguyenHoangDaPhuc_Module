package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    void update(Blog blog);
    void add(Blog blog);
    Page<Blog> findAll(Pageable pageable, String search, Category category);
}
