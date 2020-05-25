package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {
}
