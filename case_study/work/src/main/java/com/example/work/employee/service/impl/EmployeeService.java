package com.example.work.employee.service.impl;

import com.example.work.employee.model.Employee;
import com.example.work.employee.repository.IEmployeeRepository;
import com.example.work.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByEmployeeNameContaining(name, pageable);
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Integer id) {
        iEmployeeRepository.deleteById(id);

    }
}
