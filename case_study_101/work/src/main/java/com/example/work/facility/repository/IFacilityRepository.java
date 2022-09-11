package com.example.work.facility.repository;

import com.example.work.facility.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByFacNameContaining(String facName, Pageable pageable);
}
