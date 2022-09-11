package com.example.work.facility.service.impl;

import com.example.work.facility.model.FacilityRentType;
import com.example.work.facility.service.IFacilityRentTypeService;
import com.example.work.facility.repository.IFacilityRentTypeRepository;
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
