package com.resh.practice.parkinglot.services;

import com.resh.practice.parkinglot.exceptions.GateNotFoundException;
import com.resh.practice.parkinglot.models.*;
import com.resh.practice.parkinglot.repositories.GateRepository;
import com.resh.practice.parkinglot.repositories.ParkingLotRepository;
import com.resh.practice.parkinglot.repositories.TokenRepository;
import com.resh.practice.parkinglot.repositories.VehicleRepository;
import com.resh.practice.parkinglot.strategies.SpotAllocationStrategy;
import com.resh.practice.parkinglot.strategies.SpotAllocationStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TokenRepository tokenRepository;
    private ParkingLotRepository parkingLotRepository;

    public TokenService(GateRepository gateRepository, TokenRepository tokenRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.tokenRepository = tokenRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingToken issueParkingToken(VehicleType vehicleType, String vehicleNumber, String ownerName, int gateId ) throws GateNotFoundException {
        ParkingToken parkingToken = new ParkingToken();
        parkingToken.setEntryTime(new Date());

        Gate gate = gateRepository.getGateById(gateId);
        parkingToken.setGeneratedAtGate(gate);
        parkingToken.setGeneratedByOperator(gate.getCurrentOperator());

        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gate);
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory
                .getSpotAllocationStrategyByType(parkingLot.getAllocationStrategyType());

        parkingToken.setAllotedParkingSpot(spotAllocationStrategy.allocateParkingSpot(parkingLot, vehicleType));
        parkingToken.setVehicle(vehicleRepository.getVehicleOrStore(vehicleType, vehicleNumber, ownerName));

        //save token to get generated token id
        ParkingToken issuedToken = tokenRepository.saveIssuedToken(parkingToken);
        issuedToken.setTokenId("Token : " + issuedToken.getId());

        return issuedToken;




    }
}
