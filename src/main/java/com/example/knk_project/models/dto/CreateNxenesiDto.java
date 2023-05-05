package com.example.knk_project.models.dto;

import java.util.Date;

public class CreateNxenesiDto {
    private String username;
    private String salt;
    private String saltedPassword;
    private String emri;
    private String mbiemri;
    private Date dataLindjes;
    private int vendLindjaId;
    private int komunaId;
    private int prindiId;
    private int klasaId;

    public CreateNxenesiDto(String username,
                            String salt,
                            String saltedPassword,
                            String emri,
                            String mbiemri,
                            Date dataLindjes,
                            int vendLindjaId,
                            int komunaId,
                            int klasaId)
    {
        this.username = username;
        this.salt = salt;
        this.saltedPassword = saltedPassword;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.dataLindjes = dataLindjes;
        this.vendLindjaId = vendLindjaId;
        this.komunaId = komunaId;
        this.klasaId = klasaId;
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

    public Date getDataLindjes() {
        return dataLindjes;
    }

    public int getVendLindjaId() {
        return vendLindjaId;
    }

    public int getKomunaId() {
        return komunaId;
    }

    public int getPrindiId() {
        return prindiId;
    }

    public int getKlasaId() {
        return klasaId;
    }

    public void setPrindiId(int prindiId) {
        this.prindiId = prindiId;
    }
}
