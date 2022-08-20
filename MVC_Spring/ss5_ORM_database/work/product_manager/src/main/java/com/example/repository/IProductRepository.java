package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void add(Product product);

    void delete(int id);

    void update(Product product);

    List<Product> findByName(String name);
}
