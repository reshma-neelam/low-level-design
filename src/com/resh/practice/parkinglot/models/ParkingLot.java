package com.resh.practice.parkinglot.models;

import com.resh.practice.parkinglot.strategies.FeesCalculatorStrategy;
import com.resh.practice.parkinglot.strategies.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> vehicleTypes;
    private ParkingLotStatus status;
    private SpotAllocationStrategyType allocationStrategyType;
    private FeesCalculatorStrategyType calculatorStrategyType;

    public List<ParkingFloor> getParkingFloors() {

        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public SpotAllocationStrategyType getAllocationStrategyType() {
        return allocationStrategyType;
    }

    public void setAllocationStrategyType(SpotAllocationStrategyType allocationStrategyType) {
        this.allocationStrategyType = allocationStrategyType;
    }

    public FeesCalculatorStrategyType getCalculatorStrategyType() {
        return calculatorStrategyType;
    }

    public void setCalculatorStrategyType(FeesCalculatorStrategyType calculatorStrategyType) {
        this.calculatorStrategyType = calculatorStrategyType;
    }
}
