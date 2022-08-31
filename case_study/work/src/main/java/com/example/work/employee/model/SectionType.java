package com.example.work.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bo_phan")
public class SectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_bo_phan;
    @Column(name = "ten_bo_phan")
    private String sectionName;
    @OneToMany(mappedBy = "sectionType")
    List<Employee> employeeList;

    public SectionType() {
    }

    public SectionType(int ma_bo_phan, String sectionName, List<Employee> employeeList) {
        this.ma_bo_phan = ma_bo_phan;
        this.sectionName = sectionName;
        this.employeeList = employeeList;
    }

    public SectionType(String sectionName, List<Employee> employeeList) {
        this.sectionName = sectionName;
        this.employeeList = employeeList;
    }

    public int getMa_bo_phan() {
        return ma_bo_phan;
    }

    public void setMa_bo_phan(int ma_bo_phan) {
        this.ma_bo_phan = ma_bo_phan;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
