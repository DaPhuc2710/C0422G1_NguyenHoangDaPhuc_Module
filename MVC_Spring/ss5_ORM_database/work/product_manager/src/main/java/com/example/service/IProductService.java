package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add(Product product);

    void delete(int id);

    void update(Product product);

    Product findById(int id);

    List<Product> findByName(String name);
}
