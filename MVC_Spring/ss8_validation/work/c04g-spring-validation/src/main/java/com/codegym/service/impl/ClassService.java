package com.codegym.service.impl;

import com.codegym.model.ClassCG;
import com.codegym.repository.IClassRepository;
import com.codegym.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepository iClassRepository;

    @Override
    public List<ClassCG> findAll() {
        return this.iClassRepository.findAll();
    }
}
