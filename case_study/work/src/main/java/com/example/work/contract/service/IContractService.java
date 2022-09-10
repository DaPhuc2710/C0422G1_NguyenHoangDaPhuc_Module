package com.example.work.contract.service;

import com.example.work.contract.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    void delete(Integer id);

    Optional<Contract> findById(Integer id);

    Page<Contract> findAllByCustomerContaining(String name, Pageable pageable);

    void save(Contract contract);

    void update(Contract contract);
//    List<Contract> findAll();

}
