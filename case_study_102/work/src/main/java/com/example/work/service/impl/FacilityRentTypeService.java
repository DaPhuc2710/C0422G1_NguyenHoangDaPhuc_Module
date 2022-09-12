package com.example.work.service.impl;

import com.example.work.model.facility.FacilityRentType;
import com.example.work.service.IFacilityRentTypeService;
import com.example.work.repository.IFacilityRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityRentTypeService implements IFacilityRentTypeService {
    @Autowired
    IFacilityRentTypeRepository iFacilityRentTypeRepository;

    @Override
    public List<FacilityRentType> findAll() {
        return iFacilityRentTypeRepository.findAll();
    }
}
