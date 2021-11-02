package com.emard.movieinfosservice.models;

public class Movie {
    
    private String movieId;
    private String name;

    public Movie() {
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie movieId(String movieId) {
        setMovieId(movieId);
        return this;
    }

    public Movie name(String name) {
        setName(name);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " movieId='" + getMovieId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
