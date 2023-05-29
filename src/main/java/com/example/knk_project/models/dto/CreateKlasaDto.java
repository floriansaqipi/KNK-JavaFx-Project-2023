package com.example.knk_project.models.dto;

public class CreateKlasaDto {

    private int klasa;
    private int paralelja;
    private String viti;

    public CreateKlasaDto(int klasa, int paralelja, String viti) {
        this.klasa = klasa;
        this.paralelja = paralelja;
        this.viti = viti;
    }


    public int getKlasa() {
        return klasa;
    }

    public int getParalelja() {
        return paralelja;
    }

    public String getViti() {
        return viti;
    }
}



