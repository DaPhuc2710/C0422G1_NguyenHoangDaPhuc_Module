package com.example.repository;

import com.example.model.Nationality;

import java.util.List;

public interface INationalityRepository {
    List<Nationality> findAll();
}
