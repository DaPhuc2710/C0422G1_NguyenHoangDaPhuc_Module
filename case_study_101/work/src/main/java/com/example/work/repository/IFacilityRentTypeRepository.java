package com.example.work.repository;

import com.example.work.model.facility.FacilityRentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRentTypeRepository extends JpaRepository<FacilityRentType, Integer> {
}
