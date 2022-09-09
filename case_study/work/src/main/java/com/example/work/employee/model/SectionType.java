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
@Table(name = "bo_phan")
public class SectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_bo_phan;
    @Column(name = "ten_bo_phan")
    private String sectionName;
    @OneToMany(mappedBy = "sectionType")
    List<Employee> employeeList;
}
