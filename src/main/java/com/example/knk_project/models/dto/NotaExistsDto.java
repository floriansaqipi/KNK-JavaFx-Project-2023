package com.example.knk_project.models.dto;

public class NotaExistsDto {
    private int gjysmeVjetori;
    private int rubrika;
    private int nxenesiId;
    private int lendaId;

    public NotaExistsDto(int gjysmeVjetori, int rubrika, int nxenesiId, int lendaId) {
        this.gjysmeVjetori = gjysmeVjetori;
        this.rubrika = rubrika;
        this.nxenesiId = nxenesiId;
        this.lendaId = lendaId;
    }

    public int getGjysmeVjetori() {
        return gjysmeVjetori;
    }

    public int getRubrika() {
        return rubrika;
    }

    public int getNxenesiId() {
        return nxenesiId;
    }

    public int getLendaId() {
        return lendaId;
    }
}
