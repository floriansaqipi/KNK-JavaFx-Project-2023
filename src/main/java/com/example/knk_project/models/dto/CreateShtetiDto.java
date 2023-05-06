package com.example.knk_project.models.dto;

public class CreateShtetiDto {
    private int id;
    private String emri;


    public CreateShtetiDto(int id, String emri) {
        this.id = id;
        this.emri = emri;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }
}
