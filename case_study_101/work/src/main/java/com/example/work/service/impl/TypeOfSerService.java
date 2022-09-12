package com.example.work.service.impl;

import com.example.work.model.facility.TypeOfSer;
import com.example.work.service.ITypeOfSerService;
import com.example.work.repository.ITypeOfSerRepository;
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
