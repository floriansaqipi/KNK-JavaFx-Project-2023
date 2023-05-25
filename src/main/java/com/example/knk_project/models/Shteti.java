package com.example.knk_project.models;

public class Shteti {
private int id;
private String emri;


    public Shteti(int id, String emri) {
        this.id = id;
        this.emri = emri;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }
}
