package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Car")
public class Car {
    private String numberPlate;
    private String vehicleMake;
    private String vehicleModel;
    private int year;
    private int doorCount;
    private boolean Automatic;
    private boolean conditionOf_AC;

    public Car() {
    }

    public Car(String numberPlate, String vehicleMake, String vehicleModel, int year, int doorCount, boolean automatic, boolean conditionOf_AC) {
        this.numberPlate = numberPlate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.year = year;
        this.doorCount = doorCount;
        this.Automatic = automatic;
        this.conditionOf_AC = conditionOf_AC;
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

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public boolean isAutomatic() {
        return Automatic;
    }

    public void setAutomatic(boolean automatic) {
        Automatic = automatic;
    }

    public boolean isConditionOf_AC() {
        return conditionOf_AC;
    }

    public void setConditionOf_AC(boolean conditionOf_AC) {
        this.conditionOf_AC = conditionOf_AC;
    }
}
