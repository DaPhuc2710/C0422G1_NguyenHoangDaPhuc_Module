package com.example.repository.impl;

import com.example.model.MedicalReport;
import com.example.repository.IMedicalReportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalReportRepository implements IMedicalReportRepository {
    static private List<MedicalReport> medicalReportList = new ArrayList<>();

    static {
        medicalReportList.add(new MedicalReport("Đa Phúc", "2000", "male", "Việt Nam", "201790843", "Ôtô", "C111", "B123", "10", "10", "2020", "20", "11", "2020", "chưa tiêm chủng"));
        medicalReportList.add(new MedicalReport("Hà Duyên", "2000", "female", "Việt Nam", "201790686", "Ôtô", "C112", "B122", "10", "10", "2020", "20", "11", "2020", "chưa tiêm chủng"));
        medicalReportList.add(new MedicalReport("Thuận Châu", "2000", "male", "Việt Nam", "20179999", "Máy bay", "A123", "B120", "10", "10", "2020", "20", "11", "2020", "chưa tiêm chủng"));
        medicalReportList.add(new MedicalReport("Thủy Tiên", "2000", "female", "Việt Nam", "201790777", "Tàu Thuyền", "S123", "B119", "10", "10", "2020", "20", "11", "2020", "chưa tiêm chủng"));
    }


    @Override
    public List<MedicalReport> findAll() {
        return medicalReportList;
    }

    @Override
    public void save(MedicalReport medicalReport) {

    }
}
