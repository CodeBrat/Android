package com.codebrat.java;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bharath on 5/11/2017.
 */

public class Movie implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(year);
    }

    protected Movie(Parcel in) {
        title = in.readString();
        genre = in.readString();
        year = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
