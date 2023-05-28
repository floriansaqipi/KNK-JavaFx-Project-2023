package com.example.knk_project.models;

public class AdminProfesorKlasaTableView {
    private Profesori profesori;
    private Klasa klasa;

    public AdminProfesorKlasaTableView(Profesori profesori, Klasa klasa) {
        this.profesori = profesori;
        this.klasa = klasa;
    }

    public Profesori getProfesori() {
        return profesori;
    }

    public Klasa getKlasa() {
        return klasa;
    }
}
