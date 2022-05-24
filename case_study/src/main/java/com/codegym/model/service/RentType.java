package com.codegym.model.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class RentType {
    @Id
    private Integer rentTypeId;
    private String rentTypeName;

    @OneToMany(mappedBy = "rentTypeId")
    private List<Service> listRentType;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<Service> getListRentType() {
        return listRentType;
    }

    public void setListRentType(List<Service> listRentType) {
        this.listRentType = listRentType;
    }
}
