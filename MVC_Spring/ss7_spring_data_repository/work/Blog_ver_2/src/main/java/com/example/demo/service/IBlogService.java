package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    void update(Blog blog);
    void add(Blog blog);
    Page<Blog> findAll(Pageable pageable);
}
