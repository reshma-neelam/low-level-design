package com.resh.practice.bookmyshow.models;

import java.util.List;

public class Booking extends BaseModel{

    private Show show;
    private List<Map_SeatForShow> bookedSeats;
    private int totalPrice;
    private BookingStatus status;
    private List<Payment> payments;
    private User user;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Map_SeatForShow> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Map_SeatForShow> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
