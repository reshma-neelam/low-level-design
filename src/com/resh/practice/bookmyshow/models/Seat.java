package com.resh.practice.bookmyshow.models;


public class Seat extends BaseModel {

    private String seatNumber;
    private SeatType seatType;

    //since screen layouts are stored as standard grids
    private int row;
    private int column;
}
