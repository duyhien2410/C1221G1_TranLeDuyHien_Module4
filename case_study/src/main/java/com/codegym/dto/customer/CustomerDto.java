package com.codegym.dto.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer customerId;
    private String customerCode;
    private CustomerType customerTypeId;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String customerName;
    private String customerBirthday;
    private Integer gender;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "(^\\d{9})|(\\d{12})$", message = "{idcard.invalid}")
    private String customerIdCard;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^(((090)|(091))\\d{7})|(([(]84[)][+](90)|[(]84[)][+](91))\\d{7})$", message = "{phone.invalid}")
    private String customerPhone;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Email(message = "{email.invalid}")
    private String customerEmail;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String customerAddress;

    public CustomerDto() {
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
