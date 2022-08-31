package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByContentContaining(Pageable pageable, String search);
    Page<Blog> findAllByContentContainingAndCategory(Pageable pageable, String search, Category category);
    Page<Blog> findAllByCategory_IdCate (Integer id, Pageable pageable);

}
