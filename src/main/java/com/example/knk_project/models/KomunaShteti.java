package com.example.knk_project.models;

public class KomunaShteti {
    private int komunaID;
    private String emriKomunes;
    private int shtetiID;
    private String emriShtetit;

    public KomunaShteti(int komunaID, String emriKomunes, int shtetiID, String emriShtetit) {
        this.komunaID = komunaID;
        this.emriKomunes = emriKomunes;
        this.shtetiID = shtetiID;
        this.emriShtetit = emriShtetit;
    }

    public int getKomunaID() {
        return komunaID;
    }

    public String getEmriKomunes() {
        return emriKomunes;
    }

    public int getShtetiID() {
        return shtetiID;
    }

    public String getEmriShtetit() {
        return emriShtetit;
    }

    public void setKomunaID(int komunaID) {
        this.komunaID = komunaID;
    }

    public void setEmriKomunes(String emriKomunes) {
        this.emriKomunes = emriKomunes;
    }

    public void setShtetiID(int shtetiID) {
        this.shtetiID = shtetiID;
    }

    public void setEmriShtetit(String emriShtetit) {
        this.emriShtetit = emriShtetit;
    }
}
