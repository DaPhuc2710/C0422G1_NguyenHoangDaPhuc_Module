package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IProductService {
    Page<Product> findByName(String name ,Pageable pageable);

    void add(Product product);



    void update(Product product);

    Product findById(int id);
}
