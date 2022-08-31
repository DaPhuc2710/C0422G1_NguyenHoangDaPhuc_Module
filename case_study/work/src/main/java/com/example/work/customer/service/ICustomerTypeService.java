package com.example.work.customer.service;

import com.example.work.customer.model.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
