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
@Table(name = "vi_tri")
public class PositionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private int ma_vi_tri;
    @Column(name = "ten_vi_tri")
    private String positionName;
    @OneToMany(mappedBy = "positionType")
    List<Employee> employeeList;
}
