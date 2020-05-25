package com.company;

import java.io.IOException;

public interface VehicleRentalManager { // creating the interface of vehicle rental
    Vehicle addVehicle(Vehicle item);
    Vehicle deleteVehicle(Vehicle item,String plateNo);
    void printList();
    void saveVehicle() throws IOException;
    Vehicle updateVehicle(Vehicle item);
}
