package com.example.work.repository;

import com.example.work.model.employee.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionTypeRepository extends JpaRepository<PositionType,Integer> {
}
