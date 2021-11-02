package com.emard.ratingsdataservice.models;
 

public class Rating {
    private String movieId;
    private Integer rating;

    public Rating() {
    }

    public Rating(String movieId, Integer rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Rating movieId(String movieId) {
        setMovieId(movieId);
        return this;
    }

    public Rating rating(Integer rating) {
        setRating(rating);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " movieId='" + getMovieId() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

}
