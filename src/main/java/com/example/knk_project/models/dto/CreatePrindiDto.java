package com.example.knk_project.models.dto;

public class CreatePrindiDto {
    private String emri;
    private String mbiemri;
    private String profesioni;
    private String adresa;
    private String numriTelefonit;
    private String email;

    public CreatePrindiDto(
            String emri,
            String mbiemri,
            String profesioni,
            String adresa,
            String numriTelefonit,
            String email)
    {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.profesioni = profesioni;
        this.adresa = adresa;
        this.numriTelefonit = numriTelefonit;
        this.email = email;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getProfesioni() {
        return profesioni;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumriTelefonit() {
        return numriTelefonit;
    }

    public String getEmail() {
        return email;
    }
}
