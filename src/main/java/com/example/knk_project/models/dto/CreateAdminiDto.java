package com.example.knk_project.models.dto;

public class CreateAdminiDto {

    private String username;
    private String salt;
    private String saltedPassword;
    private String emri;
    private String mbiemri;
    private String titulli;

    public CreateAdminiDto(
            String username,
            String salt,
            String saltedPassword,
            String emri,
            String mbiemri,
            String titulli)
    {
        this.username = username;
        this.salt = salt;
        this.saltedPassword = saltedPassword;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.titulli = titulli;
    }


    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getTitulli() {
        return titulli;
    }
}

