package com.resh.practice.parkinglot;

import com.resh.practice.parkinglot.controllers.TokenController;
import com.resh.practice.parkinglot.repositories.GateRepository;
import com.resh.practice.parkinglot.repositories.ParkingLotRepository;
import com.resh.practice.parkinglot.repositories.TokenRepository;
import com.resh.practice.parkinglot.repositories.VehicleRepository;
import com.resh.practice.parkinglot.services.TokenService;

public class ParkingLotApplication {

    public static void main(String[] args) {

        //instantiate repos first
        TokenRepository tokenRepository = new TokenRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();

        //next service
        TokenService tokenService = new TokenService(gateRepository, tokenRepository,vehicleRepository,
                parkingLotRepository);

        //last controller instantiation
        TokenController tokenController = new TokenController(tokenService);

        System.out.println("Parking Lot Application is ready and running");
    }
}
