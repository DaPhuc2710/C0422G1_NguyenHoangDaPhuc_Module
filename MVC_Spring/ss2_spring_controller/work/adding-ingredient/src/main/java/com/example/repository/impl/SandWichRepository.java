package com.example.repository.impl;

import com.example.model.Ingredient;
import com.example.repository.ISandWichRepository;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class SandWichRepository implements ISandWichRepository {
    static List<Ingredient> ingredients= new ArrayList<>();
    static {
        ingredients.add(new Ingredient("Lettuce"));
        ingredients.add(new Ingredient("Tomato"));
        ingredients.add(new Ingredient("Mustard"));
        ingredients.add(new Ingredient("Sprouts"));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredients;
    }
}
