package com.example.work.model.contract;

import com.example.work.model.customer.Customer;
import com.example.work.model.employee.Employee;
import com.example.work.model.facility.Facility;

import javax.persistence.*;


@Entity
@Table(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Integer contractId;
    @Column(name = "ngay_lam_hop_dong")
    private String beginDate;
    @Column(name = "ngay_ket_thuc")
    private String endDate;

    @Column(name = "tien_dat_coc")
    private Double deposit;
    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu", referencedColumnName = "ma_dich_vu")
    private Facility facility;

    public Contract() {
    }

    public Contract(String beginDate, String endDate, Double deposit, Employee employee, Customer customer, Facility facility) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Contract(Integer contractId, String beginDate, String endDate, Double deposit, Employee employee, Customer customer, Facility facility) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
