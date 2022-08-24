package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> showList();
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    void update(Blog blog);
    void add(Blog blog);



}
