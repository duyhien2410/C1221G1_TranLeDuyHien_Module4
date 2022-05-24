package com.codegym.model.employee;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position positionId;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegreeId;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division divisionId;

}
