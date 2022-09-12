package com.example.work.service.impl;

import com.example.work.model.employee.PositionType;

import com.example.work.repository.IPositionTypeRepository;
import com.example.work.service.IPositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionTypeService implements IPositionTypeService {
    @Autowired
    private IPositionTypeRepository iPositionTypeRepository;
    @Override
    public List<PositionType> findAll() {
        return iPositionTypeRepository.findAll();
    }
}
