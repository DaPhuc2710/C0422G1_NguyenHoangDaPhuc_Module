package com.example.work.facility.service.impl;

import com.example.work.facility.model.TypeOfSer;
import com.example.work.facility.service.ITypeOfSerService;
import com.example.work.facility.repository.ITypeOfSerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfSerService implements ITypeOfSerService {
    @Autowired
    ITypeOfSerRepository iTypeOfSerRepository;

    @Override
    public List<TypeOfSer> findAll() {
        return iTypeOfSerRepository.findAll();
    }
}
