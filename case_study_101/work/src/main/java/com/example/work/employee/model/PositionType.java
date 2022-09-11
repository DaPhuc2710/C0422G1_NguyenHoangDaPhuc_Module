package com.example.work.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vi_tri")
public class PositionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer ma_vi_tri;
    @Column(name = "ten_vi_tri")
    private String positionName;
    @OneToMany(mappedBy = "positionType")
    List<Employee> employeeList;

    public PositionType(Integer ma_vi_tri, String positionName, List<Employee> employeeList) {
        this.ma_vi_tri = ma_vi_tri;
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public PositionType(String positionName, List<Employee> employeeList) {
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public PositionType() {
    }

    public Integer getMa_vi_tri() {
        return ma_vi_tri;
    }

    public void setMa_vi_tri(Integer ma_vi_tri) {
        this.ma_vi_tri = ma_vi_tri;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
