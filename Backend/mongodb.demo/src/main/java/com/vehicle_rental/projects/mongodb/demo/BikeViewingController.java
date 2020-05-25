package com.vehicle_rental.projects.mongodb.demo;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BikeViewingController {

    private MotorBikeRepository repository;
    public BikeViewingController( MotorBikeRepository repository){
        this.repository = repository;
    }

    @RequestMapping("/vehicle1")
    public List<MotorBike> getData(){
        return this.repository.findAll();
    }


}
