package com.codebrat.java;

/**
 * Created by Bharath on 5/11/2017.
 */

public class Movie {

    private String title;
    private String genre;
    private String year;

    public Movie(){

    }

    public Movie(String title, String genre, String year){
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title+", "+genre+", "+year;
    }
}
