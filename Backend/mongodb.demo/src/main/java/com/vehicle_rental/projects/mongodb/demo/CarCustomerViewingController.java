package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarCustomerViewingController {
    private CarCustomerRepository carCustomerRepository;

    public CarCustomerViewingController(CarCustomerRepository carCustomerRepository) {
        this.carCustomerRepository = carCustomerRepository;
    }


    @PostMapping("/employh")
    public carCustomer newEmployee(@Valid @RequestBody carCustomer newEmployee) {
        System.out.println("i got" + newEmployee.getFullName());
        return carCustomerRepository.save(newEmployee);
    }

}
