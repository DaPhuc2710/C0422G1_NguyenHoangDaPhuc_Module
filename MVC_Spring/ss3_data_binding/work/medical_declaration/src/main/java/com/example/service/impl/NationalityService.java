package com.example.service.impl;

import com.example.model.Nationality;
import com.example.repository.INationalityRepository;
import com.example.service.INationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityService implements INationalityService {
    @Autowired
    private INationalityRepository iNationalityRepository;

    @Override
    public List<Nationality> findAll() {
        return iNationalityRepository.findAll();
    }
}
