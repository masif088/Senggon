package com.example.admin.model;

public class ModelResult extends ModelDisease {
    private double rating;

    public ModelResult(String id, String title, String description, double rating) {
        super(id, title, description);
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
