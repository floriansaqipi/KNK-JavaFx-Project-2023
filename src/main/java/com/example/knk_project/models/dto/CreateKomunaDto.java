package com.example.knk_project.models.dto;

public class CreateKomunaDto {
    private String emri;
    private int shtetiId;


    public CreateKomunaDto(String emri, int shtetiId) {
        this.emri = emri;
        this.shtetiId = shtetiId;
    }


    public String getEmri() {
        return emri;
    }

    public int getShtetiId() {
        return shtetiId;
    }
}
