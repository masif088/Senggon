package com.example.admin.model;

public class ModelLearning {
    public static String CHILD="LEARNING";
    String id, id_disease,id_symtoms;
    double rate;

    public ModelLearning(String id, String id_disease, String id_symtoms, double rate) {
        this.id = id;
        this.id_disease = id_disease;
        this.id_symtoms = id_symtoms;
        this.rate = rate;
    }
    public ModelLearning(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_disease() {
        return id_disease;
    }

    public void setId_disease(String id_disease) {
        this.id_disease = id_disease;
    }

    public String getId_symtoms() {
        return id_symtoms;
    }

    public void setId_symtoms(String id_symtoms) {
        this.id_symtoms = id_symtoms;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
