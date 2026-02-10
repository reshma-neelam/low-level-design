package com.resh.practice.parkinglot.strategies;

import com.resh.practice.parkinglot.models.ParkingLot;
import com.resh.practice.parkinglot.models.SpotAllocationStrategyType;

public class SpotAllocationStrategyFactory {

    public static SpotAllocationStrategy getSpotAllocationStrategyByType(SpotAllocationStrategyType spotAllocationStrategyType){
        return switch (spotAllocationStrategyType) {
            case NearestSpotAllocationStrategy -> new NearestSpotAllocationStrategy();
            case RandomSpotAllocationStrategy -> new RandomSpotAllocationStrategy();
        };
    }
}
