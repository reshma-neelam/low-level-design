package com.resh.practice.parkinglot.strategies;

import com.resh.practice.parkinglot.models.*;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{


    @Override
    public ParkingSpot allocateParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSpot spot : parkingFloor.getParkingSpots()){
                if(spot.getSupportedVehicleTypes().contains(vehicleType) &&
                spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    return spot;
                }
            }
        }
        return null;
    }
}
