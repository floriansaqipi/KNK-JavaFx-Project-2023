package com.example.knk_project.models.dto;

public class UpdateShtetiDto {
    int id;
    String emri;

    public UpdateShtetiDto(int id, String emri) {
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
