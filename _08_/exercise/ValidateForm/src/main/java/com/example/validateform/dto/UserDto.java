package com.example.validateform.dto;

import javax.validation.constraints.*;

public class UserDto {
    private Integer id;

    @NotBlank(message = "First name is not empty!")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "First name is not empty!")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank(message = "Phone is not empty!")
    @Pattern(regexp = "^09[0|1][0-9]{7}$")
    private String phoneNumber;

    @NotNull
    @Min(18)
    private Integer age;

    @NotBlank(message = "Email is not empty!")
    @Email(message = "Email is not valid", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
