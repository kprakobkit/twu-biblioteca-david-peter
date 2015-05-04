package com.twu.biblioteca;

/**
 * Created by kprakobk on 5/3/15.
 */
public class Movie {
    private String name;
    private String year;
    private String director;
    private Integer rating;

    public Movie(String name, String year, String director, Integer rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%-50s|%-5s|%-15s|%-4s", name, year, director, rating);
    }
}
