package com.building.control.model;

import jakarta.persistence.Entity;

@Entity
public class CommonRoom extends Room {

    private String roomType; // Gym, Library, Laundry

    public CommonRoom() {}

    public CommonRoom(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
}
