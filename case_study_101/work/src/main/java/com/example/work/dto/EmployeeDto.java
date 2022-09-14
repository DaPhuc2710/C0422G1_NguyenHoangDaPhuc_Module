package com.example.work.dto;

import com.example.work.model.contract.Contract;
import com.example.work.model.employee.PositionType;
import com.example.work.model.employee.SectionType;
import com.example.work.model.employee.StandardType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotNull(message = "không được để trống")
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$", message = "Tên không được chứa số và Phải viết hoa chữ cái đầu ")
    private String employeeName;

    @NotNull(message = "không được để trống")
    @NotBlank(message = "không được để trống")
    private String dayOfBirth;

    @NotNull(message = "không được để trống")
    @Pattern(regexp = "^([0-9]{9})$", message = "CMND phải đủ 9 số")
    private String idNumber;

    @NotNull(message = "không được để trống")
    @Min(value = 0, message = "Lương phải là số dương")
    private Double payment;

    @NotNull(message = "không được để trống")
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^((84\\+|0)+(90|91)+[0-9]{7})$", message = "Nhập đúng định dạng (84+/0)+(90/91)+XXXXXXX")
    private String phoneNum;

    @Email(message = "Sai định dạng email")
    @NotBlank(message = "Không được để trống")
    private String email;

    private PositionType positionType;
    private StandardType standardType;
    private SectionType sectionType;
    List<Contract> contractList;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public StandardType getStandardType() {
        return standardType;
    }

    public void setStandardType(StandardType standardType) {
        this.standardType = standardType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
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
        EmployeeDto employeeDto = (EmployeeDto) target;
        LocalDate now = LocalDate.now();
        LocalDate dayOfBirth = null;
        try {
            dayOfBirth = LocalDate.parse(employeeDto.getDayOfBirth());
            if (Period.between(dayOfBirth, now).getYears() < 18 || Period.between(dayOfBirth, now).getYears() > 120) {
                errors.rejectValue("dayOfBirth", "dayOfBirth.err", "tuổi từ 18-120");
            }
        } catch (Exception e) {
            errors.rejectValue("dayOfBirth", "dayOfBirth,err", "Vui lòng nhập lại");
        }

    }
}
