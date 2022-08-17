package com.example.repository.impl;

import com.example.model.Transport;
import com.example.repository.ITransportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransportRepository implements ITransportRepository {
    static public List<Transport> transports = new ArrayList<>();

    static {
        transports.add(new Transport("Máy bay"));
        transports.add(new Transport("Thuyền, Tàu"));
        transports.add(new Transport("Ô tô"));
        transports.add(new Transport("Khác"));
    }

    @Override
    public List<Transport> findAll() {
        return transports;
    }
}
