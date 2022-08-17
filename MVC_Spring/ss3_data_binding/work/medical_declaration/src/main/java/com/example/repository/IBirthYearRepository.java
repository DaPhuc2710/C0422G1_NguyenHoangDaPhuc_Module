package com.example.repository;

import com.example.model.BirthYear;

import java.util.List;

public interface IBirthYearRepository {
    List<BirthYear> findAll();
}
