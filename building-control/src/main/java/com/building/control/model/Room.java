package com.building.control.model;

import jakarta.persistence.*;
import java.util.Random;

@MappedSuperclass
public abstract class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double currentTemperature;

    private boolean heatingEnabled;
    private boolean coolingEnabled;

    public Room() {
        this.currentTemperature = generateRandomTemperature();
    }


    private double generateRandomTemperature() {
        Random random = new Random();
        return 10 + (40 - 10) * random.nextDouble();
    }


    public void updateRoomStatus(double requestedTemp) {
        if (currentTemperature < requestedTemp) {
            heatingEnabled = true;
            coolingEnabled = false;
        } else if (currentTemperature > requestedTemp) {
            heatingEnabled = false;
            coolingEnabled = true;
        } else {
            heatingEnabled = false;
            coolingEnabled = false;
        }
    }


    public Long getId() { return id; }
    public double getCurrentTemperature() { return currentTemperature; }
    public boolean isHeatingEnabled() { return heatingEnabled; }
    public boolean isCoolingEnabled() { return coolingEnabled; }
}
