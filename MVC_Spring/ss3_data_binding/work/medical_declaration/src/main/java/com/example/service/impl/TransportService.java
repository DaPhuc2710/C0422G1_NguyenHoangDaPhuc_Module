package com.example.service.impl;

import com.example.model.Transport;
import com.example.repository.ITransportRepository;
import com.example.service.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService implements ITransportService {
    @Autowired
    private ITransportRepository iTransportRepository;

    @Override
    public List<Transport> findAll() {
        return iTransportRepository.findAll();
    }
}
