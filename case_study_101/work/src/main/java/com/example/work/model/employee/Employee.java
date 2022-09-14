package com.example.work.model.employee;

import com.example.work.model.contract.Contract;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer employeeId;
    @Column(name = "ho_ten")
    private String employeeName;
    @Column(name = "ngay_sinh")
    private String dayOfBirth;

    @Column(name = "so_cmnd")
    private String idNumber;

    @Column(name = "luong")
    private Double payment;

    @Column(name = "so_dien_thoai")
    private String phoneNum;

    private String email;
    @ManyToOne
    @JoinColumn(name = "ma_vi_tri", referencedColumnName = "ma_vi_tri")
    private PositionType positionType;
    @ManyToOne
    @JoinColumn(name = "ma_trinh_do", referencedColumnName = "ma_trinh_do")
    private StandardType standardType;
    @ManyToOne
    @JoinColumn(name = "ma_bo_phan", referencedColumnName = "ma_bo_phan")
    private SectionType sectionType;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;

    public Employee() {
    }

    public Employee(String employeeName, String dayOfBirth, String idNumber, Double payment, String phoneNum, String email, PositionType positionType, StandardType standardType, SectionType sectionType, List<Contract> contractList) {
        this.employeeName = employeeName;
        this.dayOfBirth = dayOfBirth;
        this.idNumber = idNumber;
        this.payment = payment;
        this.phoneNum = phoneNum;
        this.email = email;
        this.positionType = positionType;
        this.standardType = standardType;
        this.sectionType = sectionType;
        this.contractList = contractList;
    }

    public Employee(Integer employeeId, String employeeName, String dayOfBirth, String idNumber, Double payment, String phoneNum, String email, PositionType positionType, StandardType standardType, SectionType sectionType, List<Contract> contractList) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dayOfBirth = dayOfBirth;
        this.idNumber = idNumber;
        this.payment = payment;
        this.phoneNum = phoneNum;
        this.email = email;
        this.positionType = positionType;
        this.standardType = standardType;
        this.sectionType = sectionType;
        this.contractList = contractList;
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public StandardType getStandardType() {
        return standardType;
    }

    public void setStandardType(StandardType standardType) {
        this.standardType = standardType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
