package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface IRepository {
    List<Customer> findAll();
}
