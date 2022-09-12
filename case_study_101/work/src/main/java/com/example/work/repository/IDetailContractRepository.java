package com.example.work.repository;

import com.example.work.model.contract.DetailContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailContractRepository extends JpaRepository<DetailContract,Integer> {
}
