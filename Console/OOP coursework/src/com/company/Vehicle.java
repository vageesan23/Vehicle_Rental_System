package com.company;

import java.util.Objects;

public abstract class Vehicle { //creating a vehicle class and initialize the common attributes of sub-classes

    private String vehicleMake;
    private String vehicleModel;
    private String numberPlate;
    private int year;
    private Capacity capacity;
    private Schedule schedule;

    public Vehicle(){ //create a default constructor of vehicle class

    }

    // Generate the constructors for the attributes inside the vehicle class
    public Vehicle(String vehicleMake, String vehicleModel, String numberPlate, int year, Capacity capacity, Schedule schedule) { //adding the constructors for vehicle class
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.numberPlate = numberPlate;
        this.year = year;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    // defining the getters and setter for the vehicle class
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

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    // override the hashcode and equals methods for the vehicle class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year &&
                Objects.equals(vehicleMake, vehicle.vehicleMake) &&
                Objects.equals(vehicleModel, vehicle.vehicleModel) &&
                Objects.equals(numberPlate, vehicle.numberPlate) &&
                Objects.equals(capacity, vehicle.capacity) &&
                Objects.equals(schedule, vehicle.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleMake, vehicleModel, numberPlate, year, capacity, schedule);
    }

    //adding the toString method to the vehicle class
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", year=" + year +
                ", capacity=" + capacity +
                ", schedule=" + schedule +
                '}';
    }
}
