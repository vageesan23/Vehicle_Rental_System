package com.company;

public class Capacity {// creating a capacity class and initialize the variables
    private String capacityOfSeat;
    private String capacityOfEngine;

    public Capacity(String capacityOfSeat, String capacityOfEngine) { //creating the constructors for capacity
        this.capacityOfSeat = capacityOfSeat;
        this.capacityOfEngine = capacityOfEngine;
    }

    public Capacity(String capacityOfEngine) {
    }

    //initialize the getters and setters of capacity class
    public String getCapacityOfSeat() {
        return capacityOfSeat;
    }

    public void setCapacityOfSeat(String capacityOfSeat) {
        this.capacityOfSeat = capacityOfSeat;
    }

    public String getCapacityOfEngine() {
        return capacityOfEngine;
    }

    public void setCapacityOfEngine(String capacityOfEngine) {
        this.capacityOfEngine = capacityOfEngine;
    }

    // initialize the toString method to capacity class
    @Override
    public String toString() {
        return "Capacity{" +
                "capacityOfSeat='" + capacityOfSeat + '\'' +
                ", capacityOfEngine='" + capacityOfEngine + '\'' +
                '}';
    }
}
