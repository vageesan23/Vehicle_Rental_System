package com.company;

public class MotorBike extends Vehicle{ //creating a subclass of vehicle class and initialize the variables on it
    private int gearCount;
    private boolean haveCarrier;

    public MotorBike(int gearCount, boolean haveCarrier) { //generate the constructors for motorbike class
        this.gearCount = gearCount;
        this.haveCarrier = haveCarrier;
    }

    // calling the super class constructors inside the subclass
    public MotorBike(String vehicleMake, String vehicleModel, String numberPlate, int year, Capacity capacity, Schedule schedule, int gearCount, boolean haveCarrier) {
        super(vehicleMake, vehicleModel, numberPlate, year, capacity, schedule);
        this.gearCount = gearCount;
        this.haveCarrier = haveCarrier;
    }

    // generate the getters and setters to the motorbike class
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

    // generate toString method to motorbike class
    @Override
    public String toString() {
        return "MotorBike{" +
                "gearCount=" + gearCount +
                ", haveCarrier=" + haveCarrier +
                "} " + super.toString();
    }
}
