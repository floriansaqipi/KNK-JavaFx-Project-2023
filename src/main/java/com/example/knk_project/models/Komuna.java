package com.example.knk_project.models;

public class Komuna {
    private int id;
    private String emri;
    private int shtetiId;


    public Komuna(int id, String emri, int shtetiId) {
        this.id = id;
        this.emri = emri;
        this.shtetiId = shtetiId;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public int getShtetiId() {
        return shtetiId;
    }
}
