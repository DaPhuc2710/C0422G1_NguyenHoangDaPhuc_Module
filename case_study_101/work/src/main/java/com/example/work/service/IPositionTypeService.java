package com.example.work.service;

import com.example.work.model.employee.PositionType;

import java.util.List;

public interface IPositionTypeService {
    List<PositionType> findAll();
}
