package com.codegym.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Division {
    @Id
    private Integer divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "divisionId")
    private List<Employee> listDivision;

    public Division() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getListDivision() {
        return listDivision;
    }

    public void setListDivision(List<Employee> listDivision) {
        this.listDivision = listDivision;
    }
}
