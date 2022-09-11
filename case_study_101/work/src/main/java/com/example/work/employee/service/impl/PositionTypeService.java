package com.example.work.employee.service.impl;

import com.example.work.employee.model.PositionType;
import com.example.work.employee.repository.IPositionTypeRepository;
import com.example.work.employee.service.IPositionTypeService;
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
