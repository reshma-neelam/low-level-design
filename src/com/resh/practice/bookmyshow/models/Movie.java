package com.resh.practice.bookmyshow.models;

import java.util.List;

public class Movie extends BaseModel{

    private String name;
    private List<Genre> genre;
    private String ratings;
    private String duration;
    private List<AudioLanguage> supportedLanguages;
    private List<FormatType>  supportedFormats;
    private MovieStatus movieStatus;

}
