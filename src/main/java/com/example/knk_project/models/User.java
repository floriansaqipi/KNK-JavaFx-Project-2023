package com.example.knk_project.models;

import javafx.beans.property.StringProperty;

public class User {
    private int id;
    private String username;
    private String emri;
    private String mbiemri;
    private String roli;

    public User(int id, String username, String emri, String mbiemri, String roli) {
        this.id = id;
        this.username = username;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.roli = roli;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setRoli(String roli) {
        this.roli = roli;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getRoli() {
        return roli;
    }
}
