package com.example.work.service;

import com.example.work.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    void delete(Integer id);
    Optional<Customer> findById(Integer id);

    Page<Customer> findAllByNameCustomerContaining(String name, Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);

}
