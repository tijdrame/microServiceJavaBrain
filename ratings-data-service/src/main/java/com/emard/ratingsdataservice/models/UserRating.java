package com.emard.ratingsdataservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;

    public UserRating() {
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating ratings(List<Rating> ratings) {
        setRatings(ratings);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " ratings='" + getRatings() + "'" +
            "}";
    }

}
