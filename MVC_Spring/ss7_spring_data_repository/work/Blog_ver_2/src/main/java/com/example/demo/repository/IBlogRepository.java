package com.example.demo.repository;

import com.example.demo.model.Blog;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByDescriptionContaining(Pageable pageable, String search);
    Page<Blog> findAllByDescriptionContainingAndCategory(Pageable pageable, String search, Category category);

}
