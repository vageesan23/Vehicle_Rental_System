package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface CarCustomerRepository extends MongoRepository<carCustomer,String> {
    public carCustomer fullName(String content);
    public carCustomer  NIC(String  NIC);
    public carCustomer contactNo(int contactNo);
    public carCustomer EmailAddress(String EmailAddress);
    public carCustomer numberPlate(String numberPlate);
    public carCustomer pickUpDate(Date pickUpDate);
    public carCustomer dropDate(Date dropDate);
    public carCustomer carMake(String carMake);
    public carCustomer carModel(String carModel);
}
