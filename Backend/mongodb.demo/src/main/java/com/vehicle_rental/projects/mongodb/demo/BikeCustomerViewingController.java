package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BikeCustomerViewingController {
    private BikeCustomerRepository repository2;

    public BikeCustomerViewingController(BikeCustomerRepository repository2) {

        this.repository2 = repository2;
    }

    @PostMapping("/bikecustomer1")
    public bikeCustomer createEmployee(@Valid @RequestBody bikeCustomer customer) {
        System.out.println("Email Address : " + customer.getEmailAddress());
        return repository2.save(customer);
    }
}
