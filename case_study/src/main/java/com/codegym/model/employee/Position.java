package com.codegym.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Position {
    @Id
    private Integer positionId;
    private String positionName;

    @OneToMany(mappedBy = "positionId")
    private List<Employee> listPosition;

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getListPosition() {
        return listPosition;
    }

    public void setListPosition(List<Employee> listPosition) {
        this.listPosition = listPosition;
    }
}
