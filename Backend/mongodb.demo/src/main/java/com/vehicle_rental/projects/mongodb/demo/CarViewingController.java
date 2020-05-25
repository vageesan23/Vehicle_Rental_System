package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarViewingController {
    private CarCustomerRepository repository1;
    private CarCustomerRepository carCustomerRepository;
    private CarRepository repository;
    public CarViewingController(CarRepository repository){
        this.repository = repository;
    }


    @RequestMapping("/vehicle")
    public List<Car> getData(){
        return repository.findAll();
    }


    @RequestMapping(method=RequestMethod.GET, value="/contacts/{id}")
    public String show(@PathVariable String id) {
        System.out.println("id : "  + id);
        return "Success";
    }

    @PostMapping("/carcustomer")
    public carCustomer createEmployee(@Valid @RequestBody carCustomer customer) {
        System.out.println(customer);
        return repository1.save(customer);

    }
            }