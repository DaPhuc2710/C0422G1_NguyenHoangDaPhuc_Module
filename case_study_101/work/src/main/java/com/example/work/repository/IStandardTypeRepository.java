package com.example.work.repository;

import com.example.work.model.employee.StandardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStandardTypeRepository extends JpaRepository<StandardType,Integer> {
}
