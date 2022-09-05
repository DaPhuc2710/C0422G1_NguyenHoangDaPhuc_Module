package com.example.phone_management.service;

import com.example.phone_management.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();

    SmartPhone findById(Long id);

    SmartPhone save(SmartPhone smartPhone);


    void remove(Long id);
}
