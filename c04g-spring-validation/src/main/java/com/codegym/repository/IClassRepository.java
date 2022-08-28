package com.codegym.repository;

import com.codegym.model.ClassCG;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassCG, Integer> {
}
