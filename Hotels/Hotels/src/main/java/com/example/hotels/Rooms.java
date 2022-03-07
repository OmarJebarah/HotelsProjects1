package com.example.hotels;

public class Rooms {
    public int id;
    public int roomNumber, cost;
    public String status;

    public Rooms(int id, int roomNumber, int cost, String status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.cost = cost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
