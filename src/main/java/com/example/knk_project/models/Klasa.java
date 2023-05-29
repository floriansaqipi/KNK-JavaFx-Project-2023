package com.example.knk_project.models;

public class Klasa {
    private int id;
    private int klasa;
    private int paralelja;
    private String viti;

    public Klasa(int id, int klasa, int paralelja, String viti) {
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

    public String getViti() {
        return viti;
    }
}
