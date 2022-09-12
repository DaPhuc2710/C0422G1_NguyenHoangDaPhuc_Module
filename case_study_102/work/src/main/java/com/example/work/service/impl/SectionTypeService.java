package com.example.work.service.impl;

import com.example.work.model.employee.SectionType;

import com.example.work.repository.ISectionTypeRepository;
import com.example.work.service.ISectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionTypeService implements ISectionTypeService {
    @Autowired
    private ISectionTypeRepository iSectionTypeRepository;
    @Override
    public List<SectionType> findALL() {
        return iSectionTypeRepository.findAll();
    }
}
