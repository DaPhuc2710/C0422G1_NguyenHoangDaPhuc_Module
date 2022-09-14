package com.example.work.service.impl;

import com.example.work.dto.DetailContractQuantity;
import com.example.work.model.contract.AttachService;
import com.example.work.repository.IAttachServiceRepository;
import com.example.work.service.IAttachSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachSerService implements IAttachSerService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public List<AttachService> showListOfAttach(Integer id) {
        return iAttachServiceRepository.showListOfAttach(id);
    }

    @Override
    public List<DetailContractQuantity> showListOfAttachTotal(Integer id) {
        return iAttachServiceRepository.showListOfAttachTotal(id);
    }
}
