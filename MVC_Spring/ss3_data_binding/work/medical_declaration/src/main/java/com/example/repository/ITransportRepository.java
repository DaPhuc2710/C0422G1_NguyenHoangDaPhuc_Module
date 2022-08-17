package com.example.repository;

import com.example.model.Transport;

import java.util.List;

public interface ITransportRepository {
    List<Transport> findAll();
}
