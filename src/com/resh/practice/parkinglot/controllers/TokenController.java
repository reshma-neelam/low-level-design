package com.resh.practice.parkinglot.controllers;

import com.resh.practice.parkinglot.dtos.IssueTokenRequestDTO;
import com.resh.practice.parkinglot.dtos.IssueTokenResponseDTO;
import com.resh.practice.parkinglot.dtos.ResponseStatus;
import com.resh.practice.parkinglot.exceptions.GateNotFoundException;
import com.resh.practice.parkinglot.models.ParkingToken;
import com.resh.practice.parkinglot.services.TokenService;

public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueParkingToken(IssueTokenRequestDTO  issueTokenRequestDTO){

        IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();
        ParkingToken issuedToken = null;
        try {
            issuedToken = tokenService.issueParkingToken(issueTokenRequestDTO.getVehicleType(),
                    issueTokenRequestDTO.getVehicleNumber(), issueTokenRequestDTO.getOwnerName(),
                    issueTokenRequestDTO.getGateId());
        } catch (GateNotFoundException e) {
            issueTokenResponseDTO.setResponseStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
        }

        issueTokenResponseDTO.setResponseStatus(ResponseStatus.OK);
        issueTokenResponseDTO.setParkingToken(issuedToken);
        return issueTokenResponseDTO;
    }
}
