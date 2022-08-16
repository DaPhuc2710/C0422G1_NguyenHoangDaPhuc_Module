package com.example.service.impl;

import com.example.model.Ingredient;
import com.example.repository.IRepository;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
    private IRepository iRepository;

    @Override
    public List<Ingredient> findAll() {
        return iRepository.findAll();
    }
}
