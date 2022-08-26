package com.example.register_form.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

//cái này dùng để chỉ custome lại
public class UserDto implements Validator {
    private int id;
    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 45, message = "Sai định dạng")
    private String firstName;
    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 45, message = "Sai định dạng")
    private String lastName;
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "Sai định dạng")
    private String phoneNumber;
    @NotBlank
    @NotEmpty
    @Email(message = "Sai định dạng email")
    private String email;

    private String age;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.firstName.length() < 5 | userDto.firstName.length() > 45) {
            errors.rejectValue("firstName", "create.firstName", "Tên phải có từ 5 đến 45 ký tự");
        }
        LocalDate now = LocalDate.now();
        LocalDate age = null;
        try {
            age = LocalDate.parse(userDto.getAge());
            if (Period.between(age, now).getYears() < 18 || Period.between(age, now).getYears() > 100) {
                errors.rejectValue("age", "age.err", "tuổi từ 18-120");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "age,err", "Vui lòng nhập lại");
        }
    }

}

