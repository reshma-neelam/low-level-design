package com.resh.practice.parkinglot.models;

import java.util.Date;
import java.util.List;

public class ParkingToken extends BaseModel{

    private String tokenId;
    private ParkingSpot allotedParkingSpot;
    private Date entryTime;
    private Gate generatedAtGate;
    private Operator generatedByOperator;
    private Vehicle vehicle;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public ParkingSpot getAllotedParkingSpot() {
        return allotedParkingSpot;
    }

    public void setAllotedParkingSpot(ParkingSpot allotedParkingSpot) {
        this.allotedParkingSpot = allotedParkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGeneratedAtGate() {
        return generatedAtGate;
    }

    public void setGeneratedAtGate(Gate generatedAtGate) {
        this.generatedAtGate = generatedAtGate;
    }

    public Operator getGeneratedByOperator() {
        return generatedByOperator;
    }

    public void setGeneratedByOperator(Operator generatedByOperator) {
        this.generatedByOperator = generatedByOperator;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
