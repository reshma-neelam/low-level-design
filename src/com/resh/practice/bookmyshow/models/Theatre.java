package com.resh.practice.bookmyshow.models;

import java.util.List;

public class Theatre extends BaseModel{

    private String name;
    private List<Screen> screens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
