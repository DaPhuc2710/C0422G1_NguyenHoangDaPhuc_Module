package com.example.work.dto;

import com.example.work.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;


public class CustomerDto implements Validator {

    private Integer idCustomer;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$", message = "Tên không được chứa số và Phải viết hoa chữ cái đầu ")
    private String nameCustomer;
    @NotBlank(message = "Không được để trống")
    private String dateOfBirth;
    private Integer gender;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([0-9]{9})$", message = "CMND phải đủ 9 số")
    private String idNumber;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^((84\\+|0)+(90|91)+[0-9]{7})$", message = "Nhập đúng định dạng (84+/0)+(90/91)+XXXXXXX")
    private String phoneNumber;

    @Email(message = "Sai định dạng email")
    @NotBlank(message = "Không được để trống")
    private String email;

    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Không được để trống")
    private String address;

    private CustomerType customerType;

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto1 = (CustomerDto) target;
        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(customerDto1.getDateOfBirth());
            if (Period.between(dateOfBirth, now).getYears() < 18 || Period.between(dateOfBirth, now).getYears() > 120) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.err", "tuổi từ 18-120");
            }
        } catch (Exception e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth,err", "Vui lòng nhập lại");
        }

    }
}
