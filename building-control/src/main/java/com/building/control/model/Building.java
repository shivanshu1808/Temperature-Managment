package com.building.control.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double requestedTemperature = 20.0;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Apartment> apartments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<CommonRoom> commonRooms = new ArrayList<>();

    public Building() {}

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void addCommonRoom(CommonRoom commonRoom) {
        commonRooms.add(commonRoom);
    }

    public void updateRequestedTemperature(double newTemp) {
        this.requestedTemperature = newTemp;
    }

    public double getRequestedTemperature() { return requestedTemperature; }
    public List<Apartment> getApartments() { return apartments; }
    public List<CommonRoom> getCommonRooms() { return commonRooms; }
}
