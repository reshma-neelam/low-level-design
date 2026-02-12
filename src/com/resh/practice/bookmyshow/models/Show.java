package com.resh.practice.bookmyshow.models;

import java.time.LocalDateTime;

public class Show extends BaseModel{

    private Movie movie;
    private Screen screen;
    private AudioLanguage audioLanguage;
    private FormatType formatType;
    private LocalDateTime  startTime;
    private LocalDateTime endTime;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public AudioLanguage getAudioLanguage() {
        return audioLanguage;
    }

    public void setAudioLanguage(AudioLanguage audioLanguage) {
        this.audioLanguage = audioLanguage;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
