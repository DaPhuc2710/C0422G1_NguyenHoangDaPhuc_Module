package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.IRepository;
import com.example.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCustomer implements IServiceCustomer{
    @Autowired
    IRepository iRepository;
    @Override
    public List<Customer> findAll() {
        return iRepository.findAll();
    }
}
