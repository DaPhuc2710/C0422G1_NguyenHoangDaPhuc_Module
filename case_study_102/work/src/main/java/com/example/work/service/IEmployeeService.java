package com.example.work.service;

import com.example.work.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findById( int id);

    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);

    void save(Employee employee);

    void update(Employee employee);

    void delete(Integer id);
}
