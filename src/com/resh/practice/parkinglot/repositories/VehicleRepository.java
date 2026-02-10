package com.resh.practice.parkinglot.repositories;

import com.resh.practice.parkinglot.models.Vehicle;
import com.resh.practice.parkinglot.models.VehicleType;

import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    private Map<String, Vehicle> vehicles;

    public Vehicle getVehicleOrStore(VehicleType vehicleType, String vehicleNumber, String ownerName){

        //check if vehicle by same Number and Type exists in DB, if yes return
        // if not exists, save vehicle in DB

        if(getVehicle(vehicleNumber).isEmpty()){
            return saveVehicle(vehicleType, vehicleNumber, ownerName);
        }
        return getVehicle(vehicleNumber).get();

    }

    private Optional<Vehicle> getVehicle(String vehicleNumber){
        if(vehicles.containsKey(vehicleNumber)) {
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    private Vehicle saveVehicle(VehicleType vehicleType, String vehicleNumber, String ownerName){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setOwnerName(ownerName);

        vehicles.put(vehicleNumber, vehicle);
        return vehicle;
    }
}
