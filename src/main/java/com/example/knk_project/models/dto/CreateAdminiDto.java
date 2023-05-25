package com.example.knk_project.models.dto;

public class CreateAdminiDto {

    private String username;
    private String salt;
    private String saltedPassword;


    public CreateAdminiDto(
            String username,
            String salt,
            String saltedPassword)
    {
        this.username = username;
        this.salt = salt;
        this.saltedPassword = saltedPassword;

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

}

