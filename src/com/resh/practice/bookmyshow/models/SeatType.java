package com.resh.practice.bookmyshow.models;

public class SeatType extends BaseModel{

    //custom seatTypes defined by theatre operators like VIP, GOLD, Silver, Platinum, etc
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
