package com.example.work.customer.repository;


import com.example.work.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findByNameCustomerContaining(String name, Pageable pageable);
}
