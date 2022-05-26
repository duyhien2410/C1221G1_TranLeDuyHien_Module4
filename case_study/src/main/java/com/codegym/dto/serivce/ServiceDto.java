package com.codegym.dto.serivce;

import com.codegym.model.service.RentType;
import com.codegym.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {
    private Integer serviceId;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String serviceName;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 1, message = "{number.invalid}")
    private Integer serviceArea;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 1, message = "{number.invalid}")
    private Double serviceCost;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 1, message = "{number.invalid}")
    private Integer serviceMaxPeople;
    private RentType rentTypeId;
    private ServiceType serviceTypeId;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String standardRoom;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    private String descriptionOther;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 0, message = "{number2.invalid}")
    private Double poolArea;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Min(value = 0, message = "{number2.invalid}")
    private Integer numberOfFloors;

    public ServiceDto() {
    }

    public ServiceDto(Integer serviceId, String serviceName, Integer serviceArea, Double serviceCost,
                      Integer serviceMaxPeople, RentType rentTypeId, ServiceType serviceTypeId,
                      String standardRoom, String descriptionOther, Double poolArea, Integer numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
