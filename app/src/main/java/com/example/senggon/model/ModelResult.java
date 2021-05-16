package com.example.senggon.model;

public class ModelResult extends ModelDisease {
    private double rating;

//    public ModelDiagnosa(ModelSymtoms symtoms, boolean checked){
//        this.id=symtoms.getId();
//        this.description=symtoms.getDescription();
//        this.checked=checked;
//    }
    public ModelResult(ModelDisease disease){
        this.id= disease.getId();
        this.title=disease.getTitle();
        this.description=disease.getDescription();
        this.rating=0;
    }
    public ModelResult(String id, String title, String description, double rating) {
        super(id, title, description);
        this.rating = rating;
    }
    public ModelResult(){}
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
