package com.example.work.facility.model;

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
@Table(name = "kieu_thue")
public class FacilityRentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ma_kieu_thue;
    @Column(name = "ten_kieu_thue")
    String rentTypeName;
    @OneToMany(mappedBy = "facilityRentType")
    List<Facility> facilityList;
}
