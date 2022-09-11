package com.example.work.customer.service.impl;

import com.example.work.customer.model.CustomerType;
import com.example.work.customer.repository.ICustomerTypeRepository;
import com.example.work.customer.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
