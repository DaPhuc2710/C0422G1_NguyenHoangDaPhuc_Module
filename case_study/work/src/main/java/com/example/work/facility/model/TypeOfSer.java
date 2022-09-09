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
@Table(name = "loai_dich_vu")
public class TypeOfSer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ma_loai_dich_vu;
    @Column(name = "ten_loai_dich_vu")
    String typeSerName;
    @OneToMany(mappedBy = "typeOfSer")
    List<Facility> facilityList;
}
