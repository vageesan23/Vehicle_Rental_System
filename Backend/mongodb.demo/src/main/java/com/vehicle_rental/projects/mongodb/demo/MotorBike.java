package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MotorBike")
public class MotorBike {
    private String numberPlate;
    private String vehicleMake;
    private String vehicleModel;
    private int year;
    private int gearCount;
    private boolean haveCarrier;

    public MotorBike() {
    }

    public MotorBike(String numberPlate, String vehicleMake, String vehicleModel, int year, int gearCount, boolean haveCarrier) {
        this.numberPlate = numberPlate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.year = year;
        this.gearCount = gearCount;
        this.haveCarrier = haveCarrier;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    public boolean isHaveCarrier() {
        return haveCarrier;
    }

    public void setHaveCarrier(boolean haveCarrier) {
        this.haveCarrier = haveCarrier;
    }
}
