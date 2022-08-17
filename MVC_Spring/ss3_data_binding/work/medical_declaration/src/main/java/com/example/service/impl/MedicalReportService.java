package com.example.service.impl;


import com.example.model.MedicalReport;
import com.example.repository.IMedicalReportRepository;
import com.example.service.IMedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalReportService implements IMedicalReportService {
    @Autowired
    private IMedicalReportRepository iMedicalReportRepository;

    @Override
    public List<MedicalReport> findAll() {
        return iMedicalReportRepository.findAll();
    }

    @Override
    public void save(MedicalReport medicalReport) {
        iMedicalReportRepository.save(medicalReport);
    }

    @Override
    public void edit(MedicalReport medicalReport) {
        iMedicalReportRepository.edit(medicalReport);

    }

    @Override
    public MedicalReport findId(int id) {
        return iMedicalReportRepository.findId(id);

    }
}

