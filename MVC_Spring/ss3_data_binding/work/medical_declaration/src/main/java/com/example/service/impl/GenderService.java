package com.example.service.impl;

import com.example.model.Gender;
import com.example.repository.IGenderRepository;
import com.example.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {
    @Autowired
    private IGenderRepository iGenderRepository;

    @Override
    public List<Gender> findAll() {
        return iGenderRepository.findAll();
    }
}
