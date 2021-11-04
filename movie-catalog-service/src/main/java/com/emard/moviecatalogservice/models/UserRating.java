package com.emard.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> ratings;


    public UserRating() {
    }

    public UserRating(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating userId(String userId) {
        setUserId(userId);
        return this;
    }

    public UserRating ratings(List<Rating> ratings) {
        setRatings(ratings);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", ratings='" + getRatings() + "'" +
            "}";
    }
    

}
