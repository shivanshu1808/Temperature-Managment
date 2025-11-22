package com.building.control.model;

import jakarta.persistence.Entity;

@Entity
public class Apartment extends Room {

    private String apartmentNumber;
    private String ownerName;

    public Apartment() {}

    public Apartment(String apartmentNumber, String ownerName) {
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
    }

    public String getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}
