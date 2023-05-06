package com.example.knk_project.models.dto;

public class CreateKomunaDto {
    private int id;
    private String emri;
    private int shtetiId;


    public CreateKomunaDto(int id, String emri, int shtetiId) {
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
