package com.example.knk_project.models.dto;

public class UpdateProfesoriKlasaDto {
    private int profesoriId;
    private int lendaId;
    private int newProfesoriId;
    private int newLendaId;

    public UpdateProfesoriKlasaDto(int profesoriId, int lendaId, int newProfesoriId, int newLendaId) {
        this.profesoriId = profesoriId;
        this.lendaId = lendaId;
        this.newProfesoriId = newProfesoriId;
        this.newLendaId = newLendaId;
    }

    public int getProfesoriId() {
        return profesoriId;
    }

    public int getLendaId() {
        return lendaId;
    }

    public int getNewProfesoriId() {
        return newProfesoriId;
    }

    public int getNewLendaId() {
        return newLendaId;
    }
}
