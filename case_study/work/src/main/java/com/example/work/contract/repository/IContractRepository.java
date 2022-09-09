package com.example.work.contract.repository;

import com.example.work.contract.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    Page<Contract> findAllByCustomerContainingAndEmployeeContaining(String name, Pageable pageable);
}
