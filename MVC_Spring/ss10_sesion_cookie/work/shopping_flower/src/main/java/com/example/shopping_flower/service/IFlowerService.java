package com.example.shopping_flower.service;

import com.example.shopping_flower.model.Flower;

import java.util.Optional;

public interface IFlowerService {
    Iterable<Flower> findAll();
    Optional<Flower> findById(Long id);
}
