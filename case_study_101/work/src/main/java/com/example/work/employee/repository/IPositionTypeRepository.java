package com.example.work.employee.repository;

import com.example.work.employee.model.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionTypeRepository extends JpaRepository<PositionType,Integer> {
}
