package com.example.shopping_flower.service.impl;

import com.example.shopping_flower.model.Flower;
import com.example.shopping_flower.repository.IFlowerRepository;
import com.example.shopping_flower.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FlowerService implements IFlowerService {
    @Autowired
    private IFlowerRepository iFlowerRepository;


    @Override
    public Iterable<Flower> findAll() {
        return iFlowerRepository.findAll();
    }

    @Override
    public Optional<Flower> findById(Long id) {
        return iFlowerRepository.findById(id);
    }
}
