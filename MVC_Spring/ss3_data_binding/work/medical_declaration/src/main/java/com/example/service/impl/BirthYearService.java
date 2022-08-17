package com.example.service.impl;

import com.example.model.BirthYear;
import com.example.repository.IBirthYearRepository;
import com.example.service.IBirthYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthYearService implements IBirthYearService {
    @Autowired
    private IBirthYearRepository iBirthYearRepository;

    @Override
    public List<BirthYear> findAll() {
        return iBirthYearRepository.findAll();
    }
}
