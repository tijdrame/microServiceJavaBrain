package com.emard.movieinfosservice.models;

public class Movie {
    
    private String movieId;
    private String name;
    private String description;

    public Movie() {
    }

    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie movieId(String movieId) {
        setMovieId(movieId);
        return this;
    }

    public Movie name(String name) {
        setName(name);
        return this;
    }

    public Movie description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " movieId='" + getMovieId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

    
}
