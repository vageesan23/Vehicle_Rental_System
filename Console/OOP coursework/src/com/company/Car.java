package com.company;

public class Car extends Vehicle { //creating a subclass of vehicle class and initialize the variables on it
    private int doorCount;
    private boolean isAutomatic;
    private boolean conditionOfAc;

    // creating the constructors for car class
    public Car(int noOfDoors, boolean haveAc, boolean isAutomatic) {
        this.doorCount = doorCount;
        this.conditionOfAc = conditionOfAc;
        this.isAutomatic = isAutomatic;
    }

    // calling the super class constructors inside the subclass
    public Car(String vehicleMake, String vehicleModel, String numberPlate, int year, Capacity capacity, Schedule schedule, int doorCount, boolean isAutomatic, boolean conditionOfAc) {
        super(vehicleMake, vehicleModel, numberPlate, year, capacity, schedule);
        this.doorCount = doorCount;
        this.isAutomatic = isAutomatic;
        this.conditionOfAc = conditionOfAc;
    }

    public Car() {

    }

    // generating the getters and setters for the car class
    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public boolean isConditionOfAc() {
        return conditionOfAc;
    }

    public void setConditionOfAc(boolean conditionOfAc) {
        this.conditionOfAc = conditionOfAc;
    }

    // generate the toString method to car class
    @Override
    public String toString() {
        return "Car{" +
                "doorCount=" + doorCount +
                ", isAutomatic=" + isAutomatic +
                ", conditionOfAc=" + conditionOfAc +
                "} " + super.toString();
    }
}
