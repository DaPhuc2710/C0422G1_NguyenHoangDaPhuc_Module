package com.example.work.employee.model;

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
@Table(name = "trinh_do")
public class StandardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_trinh_do;
    @Column(name = "ten_trinh_do")
    private String standardName;
    @OneToMany(mappedBy = "standardType")
    List<Employee> employeeList;
}
