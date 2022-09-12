package com.example.work.model.facility;

import javax.persistence.*;
import java.util.List;

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

    public FacilityRentType() {
    }

    public FacilityRentType(Integer ma_kieu_thue, String rentTypeName, List<Facility> facilityList) {
        this.ma_kieu_thue = ma_kieu_thue;
        this.rentTypeName = rentTypeName;
        this.facilityList = facilityList;
    }

    public Integer getMa_kieu_thue() {
        return ma_kieu_thue;
    }

    public void setMa_kieu_thue(Integer ma_kieu_thue) {
        this.ma_kieu_thue = ma_kieu_thue;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
