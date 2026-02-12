package com.resh.practice.bookmyshow.models;

public class Map_Show_SeatType extends BaseModel{

    private Show show;
    private SeatType seatType;
    private int price;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
