package com.example.work.customer.service.impl;

import com.example.work.customer.model.Customer;
import com.example.work.customer.repository.ICustomerRepository;
import com.example.work.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllByNameCustomerContaining(String name, Pageable pageable) {
        return iCustomerRepository.findAllByNameCustomerContaining(name, pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);

    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);

    }
}
