package com.example.knk_project.models.dto;

public class UpdateKomunaDto {
    private int id;
    private String emri;
    private int shteti_id;

    public UpdateKomunaDto(int id, String emri, int shteti_id) {
        this.id = id;
        this.emri = emri;
        this.shteti_id = shteti_id;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public int getShteti_id() {
        return shteti_id;
    }

}
