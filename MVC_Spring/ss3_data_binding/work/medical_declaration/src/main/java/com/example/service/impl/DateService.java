package com.example.service.impl;

import com.example.repository.IDateRepository;
import com.example.service.IDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService implements IDateService {
    @Autowired
    private IDateRepository iDateRepository;

    @Override
    public List<String> findDateAll() {
        return iDateRepository.findDateAll();
    }

    @Override
    public List<String> findMonthAll() {
        return iDateRepository.findMonthAll();
    }

    @Override
    public List<String> findYearAll() {
        return iDateRepository.findYearAll();
    }
}
