package com.example.work.customer.service;

import com.example.work.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void delete(Customer customer);
    Optional<Customer> findById (int id);

    Page<Customer> findAllByNameCustomerContaining(String name, Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);
}
