package com.resh.practice.bookmyshow.models;

public class Map_SeatForShow extends BaseModel{

    private Seat seat;
    private Show show;
    private SeatStatus status;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
