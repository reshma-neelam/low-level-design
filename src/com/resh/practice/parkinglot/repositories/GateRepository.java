package com.resh.practice.parkinglot.repositories;

import com.resh.practice.parkinglot.exceptions.GateNotFoundException;
import com.resh.practice.parkinglot.models.Gate;
import com.resh.practice.parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();


    public Gate getGateById(int gateId) throws GateNotFoundException {
        if(gates.containsKey((long)gateId)){
            return gates.get((long) gateId);
        }

        throw new GateNotFoundException("Gate with id " + gateId + " not found");
    }




}
