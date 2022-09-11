package com.example.work.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bo_phan")
public class SectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ma_bo_phan;
    @Column(name = "ten_bo_phan")
    private String sectionName;
    @OneToMany(mappedBy = "sectionType")
    List<Employee> employeeList;

    public SectionType() {
    }

    public SectionType(String sectionName, List<Employee> employeeList) {
        this.sectionName = sectionName;
        this.employeeList = employeeList;
    }

    public SectionType(Integer ma_bo_phan, String sectionName, List<Employee> employeeList) {
        this.ma_bo_phan = ma_bo_phan;
        this.sectionName = sectionName;
        this.employeeList = employeeList;
    }

    public Integer getMa_bo_phan() {
        return ma_bo_phan;
    }

    public void setMa_bo_phan(Integer ma_bo_phan) {
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
