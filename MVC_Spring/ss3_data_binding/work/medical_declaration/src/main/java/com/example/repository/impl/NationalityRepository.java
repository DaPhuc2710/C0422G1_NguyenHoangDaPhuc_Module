package com.example.repository.impl;

import com.example.model.Nationality;
import com.example.repository.INationalityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NationalityRepository implements INationalityRepository {
    static public List<Nationality> nationalities = new ArrayList<>();

    static {
        nationalities.add(new Nationality("Việt Nam"));
        nationalities.add(new Nationality("Châu Âu"));
        nationalities.add(new Nationality("Mỹ"));
        nationalities.add(new Nationality("Trung Quốc"));
    }

    @Override
    public List<Nationality> findAll() {
        return nationalities;
    }
}
