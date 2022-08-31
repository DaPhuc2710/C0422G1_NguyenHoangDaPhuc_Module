package com.example.work.employee.service.impl;

import com.example.work.employee.model.StandardType;
import com.example.work.employee.repository.IStandardTypeRepository;
import com.example.work.employee.service.IStandardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StandardTypeService implements IStandardTypeService {
    @Autowired
    private IStandardTypeRepository iStandardTypeRepository;
    @Override
    public List<StandardType> findALL() {
        return iStandardTypeRepository.findAll();
    }
}
