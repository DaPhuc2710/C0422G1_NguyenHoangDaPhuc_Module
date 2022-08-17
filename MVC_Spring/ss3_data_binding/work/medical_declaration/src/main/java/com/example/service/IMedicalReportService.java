package com.example.service;

import com.example.model.MedicalReport;

import java.util.List;

public interface IMedicalReportService {
    List<MedicalReport> findAll();

    void save(MedicalReport medicalReport);

    void edit(MedicalReport medicalReport);
    MedicalReport findId(int id);
}
