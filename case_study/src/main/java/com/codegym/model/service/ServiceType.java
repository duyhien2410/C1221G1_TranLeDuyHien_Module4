package com.codegym.model.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    private Integer serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceTypeId")
    private List<Service> serviceTypeList;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServiceTypeList() {
        return serviceTypeList;
    }

    public void setServiceTypeList(List<Service> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }
}
