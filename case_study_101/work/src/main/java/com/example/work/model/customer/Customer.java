package com.example.work.model.customer;

import com.example.work.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Integer idCustomer;
    @Column(name = "ho_ten")
    private String nameCustomer;
    @Column(columnDefinition = "DATE", name = "ngay_sinh")
    private String dateOfBirth;
    @Column(name = "gioi_tinh")
    private Integer gender;
    @Column(name = "so_cmnd")
    private String idNumber;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    private String email;
    @Column(name = "dia_chi")
    private String address;
    @ManyToOne
    @JoinColumn(name = "ma_loai_khach", referencedColumnName = "ma_loai_khach")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contractList;

    public Customer() {
    }

    public Customer(String nameCustomer, String dateOfBirth, Integer gender, String idNumber, String phoneNumber, String email, String address, CustomerType customerType, List<Contract> contractList) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Customer(Integer idCustomer, String nameCustomer, String dateOfBirth, Integer gender, String idNumber, String phoneNumber, String email, String address, CustomerType customerType, List<Contract> contractList) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
