package com.gibby.appointmentscheduler.controller;


import com.gibby.appointmentscheduler.model.Customer;
import com.gibby.appointmentscheduler.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerRepository repo;
    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Customer> all() {
        return repo.findAll();
    }

    @PostMapping
    public Customer create(@Valid @RequestBody Customer c) {
        return repo.save(c);
    }
}
