package com.example.work.contract.service.impl;

import com.example.work.contract.model.Contract;
import com.example.work.contract.repository.IContractRepository;
import com.example.work.contract.service.IContractService;
import com.example.work.customer.model.Customer;
import com.example.work.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return iContractRepository.findAllByCustomer_NameCustomerContaining(name,pageable);
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
