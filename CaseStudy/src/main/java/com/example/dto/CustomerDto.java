package com.example.dto;

import com.example.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private int customerId;

    @Pattern(message = "*Không đúng định dạng (VD: Lê Văn An)", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String customerName;

    @NotBlank(message = "Không được để trống")
    private String dateOfBirth;

    @NotNull(message = "Không được để trống")
    private int gender;


    @Pattern(message = "*Không đúng định dạng (XXXXXXXXX với X là số từ 0 - 9)", regexp = "^[0-9]{9}$")
    private String customerIdCard;

    @Pattern(message = "*Không đúng định dạng (090XXXXXXX hoặc 091XXXXXXX với X là số từ 0 - 9)", regexp = "((84\\)+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7,}")
    private String customerPhoneNumber;

    @Email(message = "*Email không đúng định dạng (abc@example.com ...)", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String customerEmail;

    @NotBlank(message = "Không được để trống")
    private String customerAddress;

    @NotNull(message = "*Không được để trống!")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, String customerName, String dateOfBirth, int gender, String customerIdCard, String customerPhoneNumber, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.customerIdCard = customerIdCard;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
