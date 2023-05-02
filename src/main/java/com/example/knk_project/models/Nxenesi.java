package com.example.knk_project.models;

import java.util.Date;

public class Nxenesi {
    private int id;
    private String userId;
    private String salt;
    private String saltedPassword;
    private String emri;
    private String mbiemri;
    private Date dataLindjes;
    private int vendLindjaId;
    private int komunaId;
    private int prindiId;
    private int klasaId;

    public Nxenesi(
            int id,
            String userId,
            String salt,
            String saltedPassword,
            String emri,
            String mbiemri,
            Date dataLindjes,
            int vendLindjaId,
            int komunaId,
            int prindiId,
            int klasaId)
    {
        this.id = id;
        this.userId = userId;
        this.salt = salt;
        this.saltedPassword = saltedPassword;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.dataLindjes = dataLindjes;
        this.vendLindjaId = vendLindjaId;
        this.komunaId = komunaId;
        this.prindiId = prindiId;
        this.klasaId = klasaId;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
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
}
