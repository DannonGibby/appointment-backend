package com.gibby.appointmentscheduler.controller;

import com.gibby.appointmentscheduler.model.Appointment;
import com.gibby.appointmentscheduler.repository.AppointmentRepository;
import com.gibby.appointmentscheduler.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    private final AppointmentService service;
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }
    // Get all appointments
    @GetMapping
    public List<Appointment> all() {
        return service.findAll();
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public Appointment one(@PathVariable Long id) {
        return service.findByIdOrThrow(id);
    }

    // Create a new appointment
    @PostMapping
    public Appointment create(@Valid @RequestBody Appointment appointment) {
        return service.create(appointment);
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id, @Valid @RequestBody Appointment appointment) {
        return service.update(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

