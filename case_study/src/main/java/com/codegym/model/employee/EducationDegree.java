package com.codegym.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    private Integer educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegreeId")
    private List<Employee> listEducation;
}
