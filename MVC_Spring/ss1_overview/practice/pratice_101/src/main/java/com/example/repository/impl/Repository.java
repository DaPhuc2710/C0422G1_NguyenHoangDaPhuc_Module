package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository implements IRepository {
    private static List<Customer> customer = new ArrayList<>();
    static {
        customer.add(new Customer(1,"T", "t@codegym.vn", "Da Nang"));
        customer.add(new Customer(2,"Nhat", "nhat@codegym.vn", "Quang Tri"));
        customer.add(new Customer(3,"Trang", "trang@codegym.vn", "Ha Noi"));
        customer.add(new Customer(4,"Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customer.add(new Customer(5,"Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang"));
    }
    @Override
    public List<Customer> findAll() {
        return customer;
    }
}
