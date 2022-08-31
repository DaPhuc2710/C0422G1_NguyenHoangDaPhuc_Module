package com.example.work.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trinh_do")
public class StandardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_trinh_do;
    @Column(name = "ten_trinh_do")
    private String standardName;
    @OneToMany(mappedBy = "standardType")
    List<Employee> employeeList;

    public StandardType() {
    }

    public StandardType(int ma_trinh_do, String standardName, List<Employee> employeeList) {
        this.ma_trinh_do = ma_trinh_do;
        this.standardName = standardName;
        this.employeeList = employeeList;
    }

    public StandardType(String standardName, List<Employee> employeeList) {
        this.standardName = standardName;
        this.employeeList = employeeList;
    }

    public int getMa_trinh_do() {
        return ma_trinh_do;
    }

    public void setMa_trinh_do(int ma_trinh_do) {
        this.ma_trinh_do = ma_trinh_do;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
