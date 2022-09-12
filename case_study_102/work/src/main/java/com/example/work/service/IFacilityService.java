package com.example.work.service;

import com.example.work.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    void delete(Integer id);

    Optional<Facility> findById(Integer id);

    Page<Facility> findAllByFacNameCustomerContaining(String facName, Pageable pageable);

    void save(Facility facility);

    void update(Facility facility);

}
