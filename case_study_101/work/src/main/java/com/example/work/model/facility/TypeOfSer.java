package com.example.work.model.facility;

import javax.persistence.*;
import java.util.List;

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

    public TypeOfSer() {
    }

    public TypeOfSer(Integer ma_loai_dich_vu, String typeSerName, List<Facility> facilityList) {
        this.ma_loai_dich_vu = ma_loai_dich_vu;
        this.typeSerName = typeSerName;
        this.facilityList = facilityList;
    }

    public Integer getMa_loai_dich_vu() {
        return ma_loai_dich_vu;
    }

    public void setMa_loai_dich_vu(Integer ma_loai_dich_vu) {
        this.ma_loai_dich_vu = ma_loai_dich_vu;
    }

    public String getTypeSerName() {
        return typeSerName;
    }

    public void setTypeSerName(String typeSerName) {
        this.typeSerName = typeSerName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
