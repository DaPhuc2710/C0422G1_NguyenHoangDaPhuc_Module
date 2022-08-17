package com.example.repository.impl;

import com.example.model.BirthYear;
import com.example.repository.IBirthYearRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BirthYearRepository implements IBirthYearRepository {
    static public List<BirthYear> birthYearList = new ArrayList<>();

    static {
        for (int i = 1940; i <= 2022; i++) {
            birthYearList.add(new BirthYear(i + ""));
        }
    }

    @Override
    public List<BirthYear> findAll() {
        return birthYearList;
    }
}
