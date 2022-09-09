package com.example.work.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
