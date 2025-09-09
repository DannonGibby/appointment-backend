package com.gibby.appointmentscheduler.service;


import com.gibby.appointmentscheduler.model.Appointment;
import com.gibby.appointmentscheduler.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;

    public AppointmentService(AppointmentRepository repo) {
        this.repo = repo;
    }

    public List<Appointment> findAll() {
        return repo.findAll();
    }

    public Appointment findByIdOrThrow(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found: " + id));
    }

    @Transactional
    public Appointment create(Appointment a) {
        validate(a);
        return repo.save(a);
    }

    @Transactional
    public Appointment update(Long id, Appointment updated) {
        Appointment existing = findByIdOrThrow(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setLocation(updated.getLocation());
        existing.setStartTime(updated.getStartTime());
        existing.setEndTime(updated.getEndTime());
        existing.setCustomer(updated.getCustomer());
        validate(existing);
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private void validate(Appointment a) {
        if (a.getStartTime() != null && a.getEndTime() != null && !a.getEndTime().isAfter(a.getStartTime())) {
            throw new IllegalArgumentException("endTime must be after startTime");
        }
    }
}
