package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto implements Validator {

    @NotEmpty
    @NotBlank(message = "Vui long nhap giup voi.")
    @Pattern(regexp = "[A-Za-z ]+", message = "Wrong format!!! (@Pattern)")
    private String name;

    private String dateOfBirth;

    private ClassCGDto classCG;

    public StudentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ClassCGDto getClassCG() {
        return classCG;
    }

    public void setClassCG(ClassCGDto classCG) {
        this.classCG = classCG;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;

        if (!studentDto.name.matches("[A-Za-z ]+")) {
            errors.rejectValue("name",
                    "create.name",
                    "Wrong format name!!! (custom)");
        }
    }
}
