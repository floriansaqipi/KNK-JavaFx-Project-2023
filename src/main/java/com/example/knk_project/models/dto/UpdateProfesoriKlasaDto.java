package com.example.knk_project.models.dto;

public class UpdateProfesoriKlasaDto {
    private int profesoriId;
    private int klasaId;
    private int newProfesoriId;
    private int newKlasaId;


    public UpdateProfesoriKlasaDto(int profesoriId, int klasaId, int newProfesoriId, int newKlasaId) {
        this.profesoriId = profesoriId;
        this.klasaId = klasaId;
        this.newProfesoriId = newProfesoriId;
        this.newKlasaId = newKlasaId;
    }

    public int getProfesoriId() {
        return profesoriId;
    }

    public int getKlasaId() {
        return klasaId;
    }

    public int getNewProfesoriId() {
        return newProfesoriId;
    }

    public int getNewKlasaId() {
        return newKlasaId;
    }
}
