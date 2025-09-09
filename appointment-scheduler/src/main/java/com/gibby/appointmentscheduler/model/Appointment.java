package com.gibby.appointmentscheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 200)
    private String title;

    @Size(max = 1000)
    private String description;

    @Size(max = 255)
    private String location;

    @NotNull
    private LocalDateTime startTime;

    @NotNull @Future
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @PrePersist
    @PreUpdate
    private void validateTimes() {
        if (startTime != null && endTime != null && !endTime.isAfter(startTime))
            throw new IllegalArgumentException("endTime must be after startTime");
    }

    public Appointment() {}

    public Appointment(String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime, Customer customer) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public Customer getCustomer() {
        return customer;
    }



    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
