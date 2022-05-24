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
}
