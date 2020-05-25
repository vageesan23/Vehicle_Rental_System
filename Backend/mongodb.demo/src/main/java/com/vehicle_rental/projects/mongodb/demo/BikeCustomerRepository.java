package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface BikeCustomerRepository extends MongoRepository<bikeCustomer,String> {
    public bikeCustomer fullName(String content);
    public bikeCustomer  NIC(String  NIC);
    public bikeCustomer contactNo(int contactNo);
    public bikeCustomer EmailAddress(String EmailAddress);
    public bikeCustomer numberPlate(String numberPlate);
    public bikeCustomer pickUpDate(Date pickUpDate);
    public bikeCustomer dropDate(Date dropDate);
    public bikeCustomer bikeMake(String bikeMake);
    public bikeCustomer bikeModel(String bikeModel);
}
