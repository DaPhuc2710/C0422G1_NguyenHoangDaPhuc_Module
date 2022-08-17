package com.example.repository;

import com.example.model.Gender;

import java.util.List;

public interface IGenderRepository {
    List<Gender> findAll();
}
