package com.emard.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String desc;
    private Integer ratings;
    


    public CatalogItem() {
    }

    public CatalogItem(String name, String desc, Integer ratings) {
        this.name = name;
        this.desc = desc;
        this.ratings = ratings;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRatings() {
        return this.ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public CatalogItem name(String name) {
        setName(name);
        return this;
    }

    public CatalogItem desc(String desc) {
        setDesc(desc);
        return this;
    }

    public CatalogItem ratings(Integer ratings) {
        setRatings(ratings);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", desc='" + getDesc() + "'" +
            ", ratings='" + getRatings() + "'" +
            "}";
    }
}