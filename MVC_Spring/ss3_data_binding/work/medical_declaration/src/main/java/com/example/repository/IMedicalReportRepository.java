package com.example.repository;

import com.example.model.MedicalReport;

import java.util.List;

public interface IMedicalReportRepository {
    List<MedicalReport> findAll();
    void save(MedicalReport medicalReport);

    void edit(MedicalReport medicalReport);
    MedicalReport findId(int id);
}
