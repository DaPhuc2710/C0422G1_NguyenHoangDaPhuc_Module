package com.example.repository;

import com.example.model.Ingredient;

import java.util.List;

public interface IRepository {
   public List<Ingredient> findAll();
}
