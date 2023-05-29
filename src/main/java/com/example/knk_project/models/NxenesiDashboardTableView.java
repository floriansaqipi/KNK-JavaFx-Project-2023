package com.example.knk_project.models;

public class NxenesiDashboardTableView {
    private int vleraNotes;
    private int rubrikaNotes;
    private int gjysmevjetoriNotes;
    private String emriLendes;
    private String profesoriUsername;

    public NxenesiDashboardTableView(int vleraNotes, int rubrikaNotes, int gjysmevjetoriNotes, String emriLendes, String profesoriUsername) {
        this.vleraNotes = vleraNotes;
        this.rubrikaNotes = rubrikaNotes;
        this.gjysmevjetoriNotes = gjysmevjetoriNotes;
        this.emriLendes = emriLendes;
        this.profesoriUsername = profesoriUsername;
    }

    public int getVleraNotes() {
        return vleraNotes;
    }

    public int getRubrikaNotes() {
        return rubrikaNotes;
    }

    public int getGjysmevjetoriNotes() {
        return gjysmevjetoriNotes;
    }

    public String getEmriLendes() {
        return emriLendes;
    }

    public String getProfesoriUsername() {
        return profesoriUsername;
    }
}
