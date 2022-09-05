package com.example.phone_management.service.impl;

import com.example.phone_management.model.SmartPhone;
import com.example.phone_management.repository.ISmartPhoneRepository;
import com.example.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Long id) {
        return iSmartPhoneRepository.findById(id).orElse(null);
    }


    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartPhoneRepository.deleteById(id);

    }
}
