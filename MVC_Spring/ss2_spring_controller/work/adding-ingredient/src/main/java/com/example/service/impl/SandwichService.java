package com.example.service.impl;

import com.example.model.Ingredient;
import com.example.repository.ISandWichRepository;
import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SandwichService implements ISandwichService {
    @Autowired
    private ISandWichRepository iRepository;

    @Override
    public List<Ingredient> findAll() {
        return iRepository.findAll();
    }
}
