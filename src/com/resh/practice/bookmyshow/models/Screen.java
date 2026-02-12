package com.resh.practice.bookmyshow.models;

import java.util.List;

public class Screen extends BaseModel {

    private String name;
    private List<FormatType> supportedFormats;
    private List<SeatType> supportedSeats;
    private Theatre theatre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FormatType> getSupportedFormats() {
        return supportedFormats;
    }

    public void setSupportedFormats(List<FormatType> supportedFormats) {
        this.supportedFormats = supportedFormats;
    }

    public List<SeatType> getSupportedSeats() {
        return supportedSeats;
    }

    public void setSupportedSeats(List<SeatType> supportedSeats) {
        this.supportedSeats = supportedSeats;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
