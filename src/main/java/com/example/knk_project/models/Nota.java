package com.example.knk_project.models;

public class Nota {
    private int id;
    private int vlera;
    private int rubrika;
    private int gjysmevjetori;
    private int profesoriId;
    private int lendaId;
    private int nxenesiId;

    public Nota(int id, int vlera, int rubrika, int gjysmevjetori, int profesoriId, int lendaId, int nxenesiId) {
        this.id = id;
        this.vlera = vlera;
        this.rubrika = rubrika;
        this.gjysmevjetori = gjysmevjetori;
        this.profesoriId = profesoriId;
        this.lendaId = lendaId;
        this.nxenesiId = nxenesiId;
    }

    public int getId() {
        return id;
    }

    public int getVlera() {
        return vlera;
    }

    public int getRubrika() {
        return rubrika;
    }

    public int getGjysmevjetori() {
        return gjysmevjetori;
    }

    public int getProfesoriId() {
        return profesoriId;
    }

    public int getLendaId() {
        return lendaId;
    }

    public int getNxenesiId() {
        return nxenesiId;
    }
}
