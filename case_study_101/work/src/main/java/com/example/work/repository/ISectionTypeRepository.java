package com.example.work.repository;

import com.example.work.model.employee.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISectionTypeRepository extends JpaRepository<SectionType,Integer> {
}
