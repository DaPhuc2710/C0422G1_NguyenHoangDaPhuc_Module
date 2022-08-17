package com.example.model;

public class MedicalReport {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String transport;
    private String transportIdr;
    private String seatNumber;
    private String startDay;
    private String startMonth;
    private String startYear;
    private String endDay;
    private String endMonth;
    private String endYear;
    private String otherInfor;

    public MedicalReport() {
    }

    public MedicalReport(String name, String yearOfBirth, String gender, String nationality, String idCard, String transport, String transportIdr, String seatNumber, String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear, String otherInfor) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transport = transport;
        this.transportIdr = transportIdr;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.otherInfor = otherInfor;
    }

    public MedicalReport(int id, String name, String yearOfBirth, String gender, String nationality, String idCard, String transport, String transportIdr, String seatNumber, String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear, String otherInfor) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transport = transport;
        this.transportIdr = transportIdr;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.otherInfor = otherInfor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransportIdr() {
        return transportIdr;
    }

    public void setTransportIdr(String transportIdr) {
        this.transportIdr = transportIdr;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getOtherInfor() {
        return otherInfor;
    }

    public void setOtherInfor(String otherInfor) {
        this.otherInfor = otherInfor;
    }
}
