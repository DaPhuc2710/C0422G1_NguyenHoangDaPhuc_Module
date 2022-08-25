package com.example.product_manager.service.impl;

import com.example.product_manager.model.Product;
import com.example.product_manager.repository.IProductRepository;
import com.example.product_manager.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void add(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).get();
    }
}
