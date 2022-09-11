package com.example.work.employee.service.impl;

import com.example.work.employee.model.SectionType;
import com.example.work.employee.repository.ISectionTypeRepository;
import com.example.work.employee.repository.IStandardTypeRepository;
import com.example.work.employee.service.ISectionTypeService;
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
