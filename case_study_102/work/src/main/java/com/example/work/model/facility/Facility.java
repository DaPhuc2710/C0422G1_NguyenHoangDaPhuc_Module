package com.example.work.model.facility;

import com.example.work.model.contract.Contract;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "dich_vu")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer facilityId;

    @Column(name = "ten_dich_vu")
    private String facName;

    @Column(name = "dien_tich")
    private Double areaVal;

    @Column(name = "chi_phi_thue")
    private Double cost;
    @Column(name = "so_nguoi_toi_da")
    private Integer maxPeople;
    @Column(name = "tieu_chuan_phong")
    private String roomQuality;
    @Column(name = "mo_ta_tien_nghi_khac")
    private String moreDetail;
    @Column(name = "dien_tich_ho_boi")
    private Double poolAreaVal;
    @Column(name = "so_tang")
    private Integer floor;
    @Column(name = "dich_vu_mien_phi_di_kem")
    private String moreService;
    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue", referencedColumnName = "ma_kieu_thue")
    private FacilityRentType facilityRentType;
    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu", referencedColumnName = "ma_loai_dich_vu")
    private TypeOfSer typeOfSer;

    @OneToMany(mappedBy = "facility")
    private List<Contract> contractList;

    public Facility() {
    }

    public Facility(String facName, Double areaVal, Double cost, Integer maxPeople, String roomQuality, String moreDetail, Double poolAreaVal, Integer floor, String moreService, FacilityRentType facilityRentType, TypeOfSer typeOfSer, List<Contract> contractList) {
        this.facName = facName;
        this.areaVal = areaVal;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.roomQuality = roomQuality;
        this.moreDetail = moreDetail;
        this.poolAreaVal = poolAreaVal;
        this.floor = floor;
        this.moreService = moreService;
        this.facilityRentType = facilityRentType;
        this.typeOfSer = typeOfSer;
        this.contractList = contractList;
    }

    public Facility(Integer facilityId, String facName, Double areaVal, Double cost, Integer maxPeople, String roomQuality, String moreDetail, Double poolAreaVal, Integer floor, String moreService, FacilityRentType facilityRentType, TypeOfSer typeOfSer, List<Contract> contractList) {
        this.facilityId = facilityId;
        this.facName = facName;
        this.areaVal = areaVal;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.roomQuality = roomQuality;
        this.moreDetail = moreDetail;
        this.poolAreaVal = poolAreaVal;
        this.floor = floor;
        this.moreService = moreService;
        this.facilityRentType = facilityRentType;
        this.typeOfSer = typeOfSer;
        this.contractList = contractList;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public Double getAreaVal() {
        return areaVal;
    }

    public void setAreaVal(Double areaVal) {
        this.areaVal = areaVal;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRoomQuality() {
        return roomQuality;
    }

    public void setRoomQuality(String roomQuality) {
        this.roomQuality = roomQuality;
    }

    public String getMoreDetail() {
        return moreDetail;
    }

    public void setMoreDetail(String moreDetail) {
        this.moreDetail = moreDetail;
    }

    public Double getPoolAreaVal() {
        return poolAreaVal;
    }

    public void setPoolAreaVal(Double poolAreaVal) {
        this.poolAreaVal = poolAreaVal;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getMoreService() {
        return moreService;
    }

    public void setMoreService(String moreService) {
        this.moreService = moreService;
    }

    public FacilityRentType getFacilityRentType() {
        return facilityRentType;
    }

    public void setFacilityRentType(FacilityRentType facilityRentType) {
        this.facilityRentType = facilityRentType;
    }

    public TypeOfSer getTypeOfSer() {
        return typeOfSer;
    }

    public void setTypeOfSer(TypeOfSer typeOfSer) {
        this.typeOfSer = typeOfSer;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
