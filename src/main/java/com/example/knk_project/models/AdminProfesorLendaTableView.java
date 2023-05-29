package com.example.knk_project.models;

public class AdminProfesorLendaTableView {
    private Profesori profesori;
    private Lenda lenda;

    public AdminProfesorLendaTableView(Profesori profesori, Lenda lenda) {
        this.profesori = profesori;
        this.lenda = lenda;
    }

    public Profesori getProfesori() {
        return profesori;
    }

    public Lenda getLenda() {
        return lenda;
    }
}
