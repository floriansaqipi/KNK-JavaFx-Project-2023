package com.example.knk_project.models;

public class Prind {
    private int id;
    private String emri;
    private String mbiemri;
    private String profesioni;
    private String adresa;
    private String numriTelefonit;
    private String email;

    public Prind(
            int id,
            String emri,
            String mbiemri,
            String profesioni,
            String adresa,
            String numriTelefonit,
            String email)
    {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.profesioni = profesioni;
        this.adresa = adresa;
        this.numriTelefonit = numriTelefonit;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getProfesioni() {
        return profesioni;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumriTelefonit() {
        return numriTelefonit;
    }

    public String getEmail() {
        return email;
    }
}
