package com.resh.practice.parkinglot.repositories;

import com.resh.practice.parkinglot.models.ParkingToken;

import java.util.Map;
import java.util.TreeMap;

public class TokenRepository {

    //In-memory storage of entities
    private Map<Long, ParkingToken> tokens = new TreeMap<>();
    private int previousId = 0;

    public ParkingToken saveIssuedToken(ParkingToken parkingToken){
        previousId++;
        parkingToken.setId(previousId);
        tokens.put((long) previousId, parkingToken);
        return parkingToken;
    }
}
