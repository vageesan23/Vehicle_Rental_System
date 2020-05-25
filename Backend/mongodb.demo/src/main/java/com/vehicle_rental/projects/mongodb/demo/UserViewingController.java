package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class UserViewingController {
    private UserRepository userRepository;

    public UserViewingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/employ")
    public User newEmployee(@Valid @RequestBody User newEmployee) {
        System.out.println("i gfghgfhf");
        return userRepository.save(newEmployee);
    }


}
