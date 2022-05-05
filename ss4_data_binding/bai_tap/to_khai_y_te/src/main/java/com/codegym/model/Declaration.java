package com.codegym.model;

public class Declaration {
    private String name;
    private String dayOfBirth;
    private String gender;              //giới tính
    private String nationality;         //quốc tịch
    private String idCard;              //cmnd
    private String vehicle;             //phương tiện
    private String codeVehicle;         //số hiệu phương tiện
    private String seats;               //số ghế
    private String startDay;
    private String endDay;
    private String passingPlace;        //nơi đi qua

    public Declaration() {
    }

    public Declaration(String name, String dayOfBirth, String gender, String nationality, String idCard, String vehicle,
                       String codeVehicle, String seats, String startDay, String endDay, String passingPlace) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.codeVehicle = codeVehicle;
        this.seats = seats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.passingPlace = passingPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCodeVehicle() {
        return codeVehicle;
    }

    public void setCodeVehicle(String codeVehicle) {
        this.codeVehicle = codeVehicle;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getPassingPlace() {
        return passingPlace;
    }

    public void setPassingPlace(String passingPlace) {
        this.passingPlace = passingPlace;
    }
}
