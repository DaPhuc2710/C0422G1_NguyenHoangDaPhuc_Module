package com.example.repository.impl;

import com.example.model.Gender;
import com.example.repository.IGenderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenderRepository implements IGenderRepository {
    static public List<Gender> genders = new ArrayList<>();

    static {
        genders.add(new Gender("male"));
        genders.add(new Gender("female"));
    }

    @Override
    public List<Gender> findAll() {
        return genders;
    }
}
