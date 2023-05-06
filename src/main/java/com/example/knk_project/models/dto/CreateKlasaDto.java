package com.example.knk_project.models.dto;

public class CreateKlasaDto {
    private int id;
    private int klasa;
    private int paralelja;
    private int viti;

    public CreateKlasaDto(int id, int klasa, int paralelja, int viti) {
        this.id = id;
        this.klasa = klasa;
        this.paralelja = paralelja;
        this.viti = viti;
    }

    public int getId() {
        return id;
    }

    public int getKlasa() {
        return klasa;
    }

    public int getParalelja() {
        return paralelja;
    }

    public int getViti() {
        return viti;
    }
}



