package com.example.work.employee.repository;

import com.example.work.employee.model.StandardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStandardTypeRepository extends JpaRepository<StandardType,Integer> {
}
