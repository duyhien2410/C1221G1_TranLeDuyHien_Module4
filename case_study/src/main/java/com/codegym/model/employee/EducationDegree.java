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

    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getListEducation() {
        return listEducation;
    }

    public void setListEducation(List<Employee> listEducation) {
        this.listEducation = listEducation;
    }
}
