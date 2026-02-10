package com.resh.practice.parkinglot.strategies;

import com.resh.practice.parkinglot.models.ParkingFloor;
import com.resh.practice.parkinglot.models.ParkingLot;
import com.resh.practice.parkinglot.models.ParkingSpot;
import com.resh.practice.parkinglot.models.VehicleType;

public interface SpotAllocationStrategy {

    public ParkingSpot allocateParkingSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
