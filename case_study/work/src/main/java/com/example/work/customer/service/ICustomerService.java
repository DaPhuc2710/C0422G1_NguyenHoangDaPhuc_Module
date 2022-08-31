package com.example.work.customer.service;

import com.example.work.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;
public interface ICustomerService {
    void delete(Integer id);
    Optional<Customer> findById(Integer id);

    Page<Customer> findAllByNameCustomerContaining(String name, Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);
}
