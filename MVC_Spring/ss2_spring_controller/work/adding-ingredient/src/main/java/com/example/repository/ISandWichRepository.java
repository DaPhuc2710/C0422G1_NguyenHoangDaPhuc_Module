package com.example.repository;

import com.example.model.Ingredient;

import java.util.List;

public interface ISandWichRepository {
   public List<Ingredient> findAll();
}
