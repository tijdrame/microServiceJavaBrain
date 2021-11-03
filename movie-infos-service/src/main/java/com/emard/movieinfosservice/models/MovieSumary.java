package com.emard.movieinfosservice.models;

public class MovieSumary {
    private String id;
    private String title;
    private String overview;

    public MovieSumary() {
    }

    public MovieSumary(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public MovieSumary id(String id) {
        setId(id);
        return this;
    }

    public MovieSumary title(String title) {
        setTitle(title);
        return this;
    }

    public MovieSumary overview(String overview) {
        setOverview(overview);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", overview='" + getOverview() + "'" +
            "}";
    }

}
