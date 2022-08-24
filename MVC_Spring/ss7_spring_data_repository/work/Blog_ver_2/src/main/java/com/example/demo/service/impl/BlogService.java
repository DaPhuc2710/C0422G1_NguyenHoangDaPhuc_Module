package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> showList() {
        return iBlogRepository.findAll();
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
