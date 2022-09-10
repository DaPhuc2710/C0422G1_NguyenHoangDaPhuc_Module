package com.example.work.customer.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_khach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_loai_khach;
    @Column(name = "ten_loai_khach")
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    List<Customer> customerList;

    public int getMa_loai_khach() {
        return ma_loai_khach;
    }

    public void setMa_loai_khach(int ma_loai_khach) {
        this.ma_loai_khach = ma_loai_khach;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
