package com.example.work.service.impl;

import com.example.work.model.facility.Facility;
import com.example.work.service.IFacilityService;
import com.example.work.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAllByFacNameCustomerContaining(String facName, Pageable pageable) {
        return iFacilityRepository.findAllByFacNameContaining(facName, pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);

    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
