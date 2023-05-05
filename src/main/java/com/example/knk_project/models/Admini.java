package com.example.knk_project.models;

public class Admini {
    private int id;
    private String username;
    private String salt;
    private String saltedPassword;

    public Admini(
            int id,
            String username,
            String salt,
            String saltedPassword)
    {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.saltedPassword = saltedPassword;
    }

    public int getId() {
        return id;
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
