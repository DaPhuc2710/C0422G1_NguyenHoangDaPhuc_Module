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
        int id = (int) (Math.random() * 1000);
        medicalReport.setId(id);
        medicalReportList.add(medicalReport);

    }

    @Override
    public void edit(MedicalReport medicalReport) {
        for (int i = 0; i < medicalReportList.size(); i++) {
            if (medicalReport.getId() == medicalReportList.get(i).getId()) {
                medicalReportList.get(i).setName(medicalReport.getName());
                medicalReportList.get(i).setYearOfBirth(medicalReport.getYearOfBirth());
                medicalReportList.get(i).setGender(medicalReport.getGender());
                medicalReportList.get(i).setNationality(medicalReport.getNationality());
                medicalReportList.get(i).setIdCard(medicalReport.getIdCard());
                medicalReportList.get(i).setTransport(medicalReport.getTransport());
                medicalReportList.get(i).setTransportIdr(medicalReport.getTransportIdr());
                medicalReportList.get(i).setSeatNumber(medicalReport.getSeatNumber());
                medicalReportList.get(i).setStartDay(medicalReport.getStartDay());
                medicalReportList.get(i).setStartMonth(medicalReport.getStartMonth());
                medicalReportList.get(i).setStartYear(medicalReport.getStartYear());
                medicalReportList.get(i).setEndDay(medicalReport.getEndDay());
                medicalReportList.get(i).setEndMonth(medicalReport.getEndMonth());
                medicalReportList.get(i).setEndYear(medicalReport.getEndYear());
                medicalReportList.get(i).setOtherInfor(medicalReport.getOtherInfor());


            }
        }
    }

    @Override
    public MedicalReport findId(int id) {
        MedicalReport medicalReport= new MedicalReport();
        for (int i = 0; i < medicalReportList.size() ; i++) {
            if (id==medicalReportList.get(i).getId()){
                medicalReport= medicalReportList.get(i);
            }
        }
        return medicalReport;
    }
}
