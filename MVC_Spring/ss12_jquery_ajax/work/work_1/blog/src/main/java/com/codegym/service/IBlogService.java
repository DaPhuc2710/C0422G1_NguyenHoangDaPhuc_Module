package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(Integer id);

    void delete(Integer id);

    void update(Blog blog);

    void add(Blog blog);

    Page<Blog> findAll(Pageable pageable, String search, Category category);

    Page<Blog> findAllByName(String name, Pageable pageable);

    Page<Blog> findAllByCategory_IdCate(Integer id, Pageable pageable);


}
