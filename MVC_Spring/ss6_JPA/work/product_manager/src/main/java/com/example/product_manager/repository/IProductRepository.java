package com.example.product_manager.repository;



import com.example.product_manager.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
