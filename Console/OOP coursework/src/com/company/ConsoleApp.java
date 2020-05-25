package com.company;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) { //create a main method to run the console menu

        //creating a mongodb database connection to the java program
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoCredential mongoCredential = MongoCredential.createCredential("Vageesan", "VehicleRental","Vageesan123".toCharArray());
        MongoDatabase mongoDatabase = mongoClient.getDatabase("VehicleRental");
        MongoCollection <Document> DatabaseCollection = mongoDatabase.getCollection("Car");
        MongoCollection <Document> DatabaseCollection2 = mongoDatabase.getCollection("MotorBike");
        MongoCollection <Document> DatabaseCollection3 = mongoDatabase.getCollection("customer");

        WestminsterVehicleRentalManager management = new WestminsterVehicleRentalManager();
        Vehicle collection = new Car();

        Scanner Sc = new Scanner(System.in);
        int choice;

        do {//creating the do-while loop to run the console menu in between requirement
            System.out.println("Welcome to Westminster Vehicle Rental System!!! Please select any choices from below to process!!");
            System.out.println("1) Add Vehicle"+ "\n2) Update Vehicle "+ "\n3) Delete Vehicle"+ "\n4) Print the list of Vehicle"+ "\n5) Write/Save Vehicle"+ "\n6) Exit"+ "\n\nEnter Option :");
            choice = read(Sc);

            switch (choice) {
                case 1://runs the method inside Rental manager and adding the data into mongo db
                    Vehicle vehicle1 = management.addVehicle(collection);
                    Document document1 = new Document();
                    document1.append("numberPlate",vehicle1.getNumberPlate());
                    document1.append("vehicleMake",vehicle1.getVehicleMake());
                    document1.append("vehicleModel",vehicle1.getVehicleModel());
                    document1.append("year",vehicle1.getYear());
                    if(vehicle1 instanceof Car) {
                        Car car = (Car) vehicle1;
                        document1.append("doorCount", car.getDoorCount());
                        document1.append("Automatic", car.isAutomatic());
                        document1.append("ConditionOf_AC", car.isConditionOfAc());
                        DatabaseCollection.insertOne(document1);
                    }else {
                        MotorBike bike = (MotorBike) vehicle1;
                        document1.append("gearCount", bike.getGearCount());
                        document1.append("haveCarrier", bike.isHaveCarrier());
                        DatabaseCollection2.insertOne(document1);
                    }

                    break;

                case 2://runs the method inside Rental manager and updates the data inside the program
                    Vehicle vehicle3 = management.updateVehicle(collection);
                    break;

                case 3: //runs the method inside Rental manager and delete the data in mongodb
                    System.out.println("The Numberplate to delete the vehicle :");
                    Scanner scanner = new Scanner(System.in);
                    String plateNo = scanner.next();
                    management.deleteVehicle(collection,plateNo);
                    DatabaseCollection.deleteOne(Filters.eq("numberPlate", plateNo));
                    DatabaseCollection2.deleteOne(Filters.eq("numberPlate", plateNo));
                    break;

                case 4: //runs the method inside Rental manager and prints the data list inside the mongodb
                    management.printList();
                    Document document = new Document();
                    List<Document> list = DatabaseCollection.find(document).into(
                            new ArrayList<>());
                    for (Document doc:list) {
                        System.out.println(doc);
                    }
                    break;

                case 5: //runs the method inside Rental manager and save the data in a file
                    management.saveVehicle();
                    break;

                case 6: //Quits the program
                    System.out.println("Thank You... Come Back!!");
                    System.exit(0);

                default: //default to get the re-enter option if it exceeds from 1-6
                    System.out.println("Invalid input.. Please enter a number between 1-6"+ "\n>");
            }
        } while (choice > 1 || choice < 6);

    }

    private static int read(Scanner sc) { //reading the scanner method to get integer values where its needed.
        while (!sc.hasNextInt()) {
            System.out.println("You've entered a invalid input!! Please enter a number"+ "\nEnter Option :");
            sc.next();
        }
        return sc.nextInt();
    }
}