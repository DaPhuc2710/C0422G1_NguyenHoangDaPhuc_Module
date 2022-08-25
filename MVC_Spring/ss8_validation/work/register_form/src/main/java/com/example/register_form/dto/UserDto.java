package com.example.register_form.dto;


import javax.validation.constraints.*;

//cái này dùng để chỉ custome lại
public class UserDto {
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
    @Min(value = 18, message = "Phải là 18+")
    @Max(value = 120, message = "Sai định dạng")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
