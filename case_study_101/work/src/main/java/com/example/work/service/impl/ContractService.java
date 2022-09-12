package com.example.work.service.impl;

import com.example.work.dto.ContractPage;
import com.example.work.model.contract.Contract;
import com.example.work.repository.IContractRepository;
import com.example.work.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public void delete(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return iContractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAllByCustomerContaining(String name, Pageable pageable) {
        return iContractRepository.findAllByCustomer_NameCustomerContaining(name, pageable);
    }

    @Override
    public Page<ContractPage> showListContractIncludeTotalCost(Pageable pageable) {
        return iContractRepository.showListContractIncludeTotalCost(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        iContractRepository.save(contract);
    }

//    @Override
//    public List<Contract> findAll() {
//        return iContractRepository.findAll();
//    }
}
