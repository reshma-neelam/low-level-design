package com.resh.practice.parkinglot.dtos;

import com.resh.practice.parkinglot.models.VehicleType;

public class IssueTokenRequestDTO {

    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;
    private int gateId;

    public IssueTokenRequestDTO(VehicleType vehicleType, String ownerName, String vehicleNumber, int gateId) {
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }
}
