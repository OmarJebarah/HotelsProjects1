package com.example.hotels;

public class Hotels {
    public int hotel_id;
    public String name, address, evaluation;

    public Hotels(int hotel_id, String name, String address, String evaluation) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.address = address;
        this.evaluation = evaluation;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
