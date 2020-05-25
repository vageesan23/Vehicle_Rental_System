package com.company;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterVehicleRentalManager implements VehicleRentalManager { //creating the rental manager class to implement the interface VehicleRentalManager
    //creating the array lists and local variables to use inside the class
    ArrayList<Vehicle> parkingLots = new ArrayList<Vehicle>();
    ArrayList<Vehicle> vehicleStockList = new ArrayList<Vehicle>();
    final static int MAXLOTS = 50;
    Scanner sc = new Scanner(System.in);
    private long availability;

    //recalling the mongo database collection to get the count decrease count on the array list
    MongoClient mongoClient = new MongoClient("localhost",27017);
    MongoCredential mongoCredential = MongoCredential.createCredential("Vageesan", "VehicleRental","Vageesan123".toCharArray());
    MongoDatabase mongoDatabase = mongoClient.getDatabase("VehicleRental");
    MongoCollection <Document> DatabaseCollection = mongoDatabase.getCollection("Car");
    MongoCollection <Document> DatabaseCollection2 = mongoDatabase.getCollection("MotorBike");

    @Override
    public Vehicle addVehicle(Vehicle item) { //override the add vehicle method from console menu
        availability = MAXLOTS - ((DatabaseCollection.count()+DatabaseCollection2.count()));
        System.out.println("Currently the number of vehicles you can add is :" + availability);

        if (parkingLots.size() < 50) { //the if condition works until the vehicle count is less than 50
            System.out.println("The vehicle type which you can add" + "\n1) Car" + "\n2) MotorBike" + "\n3) Back to main menu" + "\n>");
            int choice = read(sc);

            if (choice == 1) { // if choice is 1 can prompt car details

                System.out.print("The make of car :");
                String vehicleMake = sc.next();

                System.out.print("The model of car :");
                String vehicleModel = sc.next();

                System.out.print("The year invention :");
                int year = read(sc);

                System.out.print("The number of NumberPlate :");
                String numberPlate = sc.next();

                System.out.print("The seat capacity of car :");
                String capacityOfSeat = sc.next();

                System.out.print("The engine capacity of car :");
                String capacityOfEngine = sc.next();

                System.out.print("The no of doors in the car :");
                int doorCount = read(sc);

                Capacity capacity = new Capacity(capacityOfSeat, capacityOfEngine);

                System.out.print("The registration year :");
                int yearDate = read(sc);

                int month = 0;
                int day = 0;

                for (int l = 0; l <= 1; l += 1) {
                    System.out.print("The registration month :");
                    month = read(sc);

                    if (month >= 1 && month <= 12) {
                        l = 1;
                    } else {
                        System.out.println("You've entered a invalid month");
                        l = 0;
                    }
                }

                for (int k = 0; k <= 1; k += 1) {
                    System.out.print("The registration date :");
                    day = read(sc);
                    if (day >= 1 && day <= 31) {
                        k = 1;
                    } else {
                        System.out.println("You've entered a invalid date");
                        k = 0;
                    }
                }

                Date date = new Date(yearDate, month, day);
                Schedule schedule = new Schedule(date);

                System.out.println("The car is AirConditioned ?" + "\n   (True/False) :");
                boolean conditionOfAc = sc.nextBoolean();

                System.out.println("The car is Automatic?" + "\n   (True/False) :");
                boolean isAutomatic = sc.nextBoolean();


                Vehicle car = new Car(vehicleMake, vehicleModel, numberPlate, year, capacity, schedule, doorCount, isAutomatic, conditionOfAc);
                parkingLots.add(car);
                System.out.println(parkingLots);

                return car;


            } else if (choice == 2) { // if choice is 2 prompt for bike details

                System.out.print("The make of MotorBike :");
                String vehicleMake = sc.next();

                System.out.print("The model of MotorBike :");
                String vehicleModel = sc.next();

                System.out.print("The year invention :");
                int year = read(sc);

                System.out.print("The number of NumberPlate :");
                String numberPlate = sc.next();

                System.out.print("The capacity of engine :");
                String capacityOfEngine = sc.next();

                Capacity capacity = new Capacity(capacityOfEngine);

                System.out.print("The Count of gear :");
                int gearCount = read(sc);

                System.out.print("The registration year :");
                int yearDate = read(sc);

                int month = 0;
                int day = 0;

                for (int l = 0; l <= 1; l += 1) {
                    System.out.print("The registration month:");
                    month = read(sc);

                    if (month >= 1 && month <= 12) {
                        l = 1;
                    } else {
                        System.out.println("You've entered a invalid month");
                        l = 0;
                    }
                }

                for (int k = 0; k <= 1; k += 1) {
                    System.out.print("The registration date:");
                    day = read(sc);
                    if (day >= 1 && day <= 31) {
                        k = 1;
                    } else {
                        System.out.println("You've entered a invalid date");
                        k = 0;
                    }
                }

                Date date = new Date(yearDate, month, day);
                Schedule schedule = new Schedule(date);

                System.out.println("The MotorBike have carrier?" + "\n   (True/False) :");
                boolean haveCarrier = sc.nextBoolean();

                Vehicle bike = new MotorBike(vehicleMake, vehicleModel, numberPlate, year, capacity, schedule, gearCount, haveCarrier);
                parkingLots.add(bike);
                System.out.println(parkingLots);

                return bike;


            } else if (choice == 3) { //if choice is 3 back to the main menu
                System.out.println("Exiting from Add Vehicle");

            } else {
                System.out.println("You've entered a invalid input");
            }

        } else { // if the vehicle count exceeds 50, then print the statement
            System.out.println("The parking lots are not available" + "\n");
        }
        return item;
    }

    @Override
    public Vehicle updateVehicle(Vehicle item) { //override the update vehicle method from console menu
        System.out.println("Enter a choice which you want to update" + "\n1) Car" + "\n2) MotorBike" + "\n3) Back to main menu" + "\n>");
        int choice = read(sc);

        if (choice == 1) { //if choice is 1 update car details
            System.out.println("Please select an option which you want to update" + "\n1) Car Make" + "\n2) Car Model" + "\n3) Car engine capacity" + "\n4) Car seat capacity" + "\n>");
            int option = read(sc);

            if (option == 1) { //if option is 1 update new make of the car
                System.out.println("The numberPlate of Car : ");
                String numberPlate = sc.next();

                boolean foundIs = false;
                for (int k = 0; k < parkingLots.size(); k += 1) {
                    if (parkingLots.get(k).getNumberPlate().equals(numberPlate)) {
                        System.out.println("Please enter the new make of the car :");
                        String newMake = sc.next();
                        parkingLots.get(k).setVehicleMake(newMake);
                        System.out.println("You've successfully updated");
                        System.out.println(parkingLots.get(k));
                        vehicleStockList.add(parkingLots.get(k));
                        try {
                            FileWriter FW = new FileWriter("test.txt", true);
                            BufferedWriter in = new BufferedWriter(FW);
                            in.write("Vehicle :" + parkingLots.get(k).getClass().getSimpleName() + "Car Make:" + parkingLots.get(k).getVehicleMake() + " Car Model :" + parkingLots.get(k).getVehicleModel() + " Year :" + parkingLots.get(k).getYear() + " Capacity :" + parkingLots.get(k).getCapacity() + " numberPlate :" + parkingLots.get(k).getNumberPlate() + " Schedule :" + parkingLots.get(k).getSchedule());
                            in.newLine();
                            in.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        foundIs = true;
                        break;
                    }

                    if (!foundIs) {
                        System.out.println("");
                    }
                }


            } else if (option == 2) { //if option is 2 update new model of the car
                MongoCollection vehicles=mongoDatabase.getCollection("Vehicles");
                System.out.println("The numberPlate of Car : ");
                String numberPlate = sc.next();
                boolean foundIs = false;
                for (int k = 0; k < parkingLots.size(); k += 1) {
                    if (parkingLots.get(k).getNumberPlate().equals(numberPlate)) {
                        System.out.println("Please enter the new model of the car :");
                        String newModel = sc.next();
                        parkingLots.get(k).setVehicleModel(newModel);
                        System.out.println("You've successfully updated");
                        System.out.println(parkingLots.get(k));
                        vehicleStockList.add(parkingLots.get(k));
                        foundIs = true;
                        break;
                    }
                }
                if (!foundIs) {
                    System.out.println("The car is not founded..");
                }

            } else if (option == 3) { //if option is 3 update new engine capacity of the car
                System.out.println("The numberPlate of Car : ");
                String numberPlate = sc.next();
                boolean foundIs = false;
                for (int k = 0; k < parkingLots.size(); k += 1) {
                    if (parkingLots.get(k).getNumberPlate().equals(numberPlate)) {
                        System.out.println("Please enter the new EngineCapacity of the car :");
                        String newEngineCapacity = sc.next();
                        parkingLots.get(k).getCapacity().setCapacityOfEngine(newEngineCapacity);
                        System.out.println("You've successfully updated");
                        System.out.println(parkingLots.get(k));
                        vehicleStockList.add(parkingLots.get(k));
                        foundIs = true;
                        break;
                    }
                }
                if (!foundIs) {
                    System.out.println("The car is not founded..");
                }


            } else if (option == 4) { //if option is 4 update new seat capacity of the car
                System.out.println("The numberPlate of Car : ");
                String numberPlate = sc.next();
                boolean foundIs = false;
                for (int k = 0; k < parkingLots.size(); k += 1) {
                    if (parkingLots.get(k).getNumberPlate().equals(numberPlate)) {
                        System.out.println("Please enter the new seat capacity of the car :");
                        String newSeatCapacity = sc.next();
                        parkingLots.get(k).getCapacity().setCapacityOfSeat(newSeatCapacity);
                        System.out.println("You've successfully updated");
                        System.out.println(parkingLots.get(k));
                        vehicleStockList.add(parkingLots.get(k));
                        foundIs = true;
                        break;
                    }
                }
                if (!foundIs) {
                    System.out.println("The car is not founded..");
                }

            } else {
                System.out.println("You've entered a invalid input");
            }

        } else if (choice == 2) { //if choice is 2 update motor bike details
            System.out.println("Please select an option which you want to update" + "\n1) MotorBike Make" + "\n2) MotorBike Model" + "\n3) MotorBike engine capacity" + "\n>");
            int option = read(sc);

            if (option == 1) { //if option is 1 update new make of the motor bike
                System.out.print("The numberPlate of MotorBike :");
                String numberPlate = sc.next();

                boolean foundIs = false;
                for (int l = 0; l < parkingLots.size(); l += 1) {
                    if (parkingLots.get(l).getNumberPlate().equals(numberPlate)) {
                        System.out.print("Please enter the new make of the MotorBike :");
                        String newMake = sc.next();
                        parkingLots.get(l).setVehicleMake(newMake);
                        System.out.println("Successfully Updated");
                        System.out.println(parkingLots.get(l));
                        vehicleStockList.add(parkingLots.get(l));
                        foundIs = true;
                        break;
                    }
                }

                if (!foundIs) {
                    System.out.println("The MotorBike is not founded..");
                }

            } else if (option == 2) { //if option is 2 update new model of the motor bike
                System.out.print("The numberPlate of MotorBike :");
                String numberPlate = sc.next();

                boolean foundIs = false;
                for (int l = 0; l < parkingLots.size(); l += 1) {
                    if (parkingLots.get(l).getNumberPlate().equals(numberPlate)) {
                        System.out.print("Please enter the new model of the MotorBike :");
                        String newModel = sc.next();
                        parkingLots.get(l).setVehicleModel(newModel);
                        System.out.println("Successfully Updated");
                        System.out.println(parkingLots.get(l));
                        vehicleStockList.add(parkingLots.get(l));
                        foundIs = true;
                        break;
                    }
                }

                if (!foundIs) {
                    System.out.println("The MotorBike is not founded..");
                }

            } else if (option == 3) { //if option is 3 update new engine capacity of the motor bike
                System.out.print("The numberPlate of MotorBike :");
                String numberPlate = sc.next();

                boolean foundIs = false;
                for (int l = 0; l < parkingLots.size(); l += 1) {
                    if (parkingLots.get(l).getNumberPlate().equals(numberPlate)) {
                        System.out.print("Please enter the new engine capacity of the MotorBike :");
                        String newEngineCapacity = sc.next();
                        parkingLots.get(l).getCapacity().setCapacityOfEngine(newEngineCapacity);
                        System.out.println("Successfully Updated");
                        System.out.println(parkingLots.get(l));
                        vehicleStockList.add(parkingLots.get(l));
                        foundIs = true;
                        break;
                    }
                }

                if (!foundIs) {
                    System.out.println("The MotorBike is not founded..");
                }

            } else {
                System.out.println("You've entered a invalid input");
            }


        } else if (choice == 3) { // if choice is 3 back to the main menu
            System.out.println("Exiting from Vehicle Update");

        } else {
            System.out.println("You've entered a invalid input");
        }
        return item;
    }

    @Override
    public Vehicle deleteVehicle(Vehicle item,String plateNo) { //override the delete vehicle method from console menu and delete the vehicle by taking plate NO

        boolean foundIs = false;
        for (Vehicle v:parkingLots) {
            if(v.getNumberPlate().equals(plateNo)){
                parkingLots.remove(v);
                System.out.println("The vehicle has been successfully deleted");
                availability = MAXLOTS - ((DatabaseCollection.count()+DatabaseCollection2.count()));
                foundIs = true;
                break;
            }
        }
        if (!foundIs) {
            System.out.println("Vehicle not found");
        }
        return item;
    }

    @Override
    public void printList() { //override the print list method from console menu and print the vehicle type and numberplate by taking the array list
        Collections.sort(parkingLots, compare);
        for (Vehicle item : parkingLots) {
            System.out.println("Vehicle type :" + item.getClass().getSimpleName() + "\nNumber Plate :" + item.getNumberPlate() + "\n");
        }
    }

    //using the comparator to get the vehicle type and numberplate in the ascending order of vehicle make
    public static Comparator<Vehicle> compare = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getVehicleMake().compareTo(v2.getVehicleMake());
        }
    };

    @Override
        public void saveVehicle() { //override the save vehicle method from console menu and saves a text file
            for (int k = 0; k < vehicleStockList.size(); k += 1) {
                for (Vehicle obj : vehicleStockList) {
                    try {
                        FileWriter FW = new FileWriter("testing_1.txt", true);
                        BufferedWriter out = new BufferedWriter(FW);
                        out.write(" Vehicle:" + obj.getClass().getSimpleName() + " Make:" + vehicleStockList.get(k).getVehicleMake() + " Model:" + vehicleStockList.get(k).getVehicleModel() + " Year:" + vehicleStockList.get(k).getYear() + " Capacity:" + vehicleStockList.get(k).getCapacity() + " PlateNo:" + vehicleStockList.get(k).getNumberPlate() + " Schedule:" + vehicleStockList.get(k).getSchedule());
                        out.newLine();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

    }

    private int read(Scanner sc) { //reading the scanner method to get integer values where its needed.
        while (!sc.hasNextInt()) {
            System.out.println("You've entered a invalid input!! Please enter a number" + "\nRe-enter :");
            sc.next();

        }
        return sc.nextInt();
    }
}

