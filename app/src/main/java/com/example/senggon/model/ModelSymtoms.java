package com.example.senggon.model;

public class ModelSymtoms {
    public static String CHILD= "SYMTOMS";
    String id, description;

    public ModelSymtoms() {
    }

    public ModelSymtoms(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
