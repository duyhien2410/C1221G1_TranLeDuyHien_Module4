package com.codegym.dto.employee;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class EmployeeDto implements Validator {
    private Integer employeeId;
    private String employeeCode;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String employeeName;
    private String employeeBirthday;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "(^\\d{9})|(\\d{12})$", message = "{idcard.invalid}")
    private String employeeIdCard;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 1, message = "{number.invalid}")
    private Double employeeSalary;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^(((090)|(091))\\d{7})|(([(]84[)][+](90)|[(]84[)][+](91))\\d{7})$", message = "{phone.invalid}")
    private String employeePhone;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Email(message = "{email.invalid}")
    private String employeeEmail;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String employeeAddress;
    private Position positionId;
    private EducationDegree educationDegreeId;
    private Division divisionId;

    public EmployeeDto() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

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

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
