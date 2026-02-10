package com.resh.practice.parkinglot.dtos;

import com.resh.practice.parkinglot.models.ParkingToken;

public class IssueTokenResponseDTO {

    private ParkingToken parkingToken;
    private ResponseStatus responseStatus;

    public ParkingToken getParkingToken() {
        return parkingToken;
    }

    public void setParkingToken(ParkingToken parkingToken) {
        this.parkingToken = parkingToken;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
