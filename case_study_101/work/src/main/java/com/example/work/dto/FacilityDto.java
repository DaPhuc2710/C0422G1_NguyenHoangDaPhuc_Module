package com.example.work.dto;

import com.example.work.contract.model.Contract;
import com.example.work.facility.model.FacilityRentType;
import com.example.work.facility.model.TypeOfSer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class FacilityDto implements Validator {
    private Integer facilityId;
    @NotNull(message = "không được để trống")
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+\\s[0-9]+$", message = "Tên không đúng định dạng X X 12")
    private String facName;
    @NotNull(message = "không được để trống")
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double areaVal;
    @NotNull(message = "không được để trống")
    @Min(value = 0, message = "Giá phải là số dương")
    private Double cost;
    @NotNull(message = "không được để trống")
    @Min(value = 0, message = "Số người phải là số dương")
    private Integer maxPeople;
    @NotBlank(message = "Không được để trống")
    private String roomQuality;
    private String moreDetail;
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double poolAreaVal;
    @Min(value = 0, message = "Số tầng phải là số dương")
    private Integer floor;
    private String moreService;
    private FacilityRentType facilityRentType;
    private TypeOfSer typeOfSer;

    private List<Contract> contractList;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.typeOfSer.getTypeSerName().equals("Room")) {

            facilityDto.floor = null;
            facilityDto.poolAreaVal = null;
            facilityDto.moreDetail = null;
        } else {
            errors.rejectValue("floor", "floor.err", "Vui lòng nhập lại");
            errors.rejectValue("poolAreaVal", "poolAreaVal.err", "Vui lòng nhập lại");
            errors.rejectValue("moreDetail", "moreDetail.err", "Vui lòng nhập lại");

        }
        if (facilityDto.typeOfSer.getTypeSerName().equals("House")) {
            facilityDto.moreService = null;
            facilityDto.poolAreaVal = null;

        } else {
            errors.rejectValue("poolAreaVal", "poolAreaVal.err", "Vui lòng nhập lại");
            errors.rejectValue("moreService", "moreService.err", "Vui lòng nhập lại");

        }
        if (facilityDto.typeOfSer.getTypeSerName().equals("Villa")) {
            facilityDto.moreService = null;

        } else {
            errors.rejectValue("moreService", "moreService.err", "Vui lòng nhập lại");
        }
    }
}
