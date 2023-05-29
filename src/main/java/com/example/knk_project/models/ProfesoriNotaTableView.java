package com.example.knk_project.models;

public class ProfesoriNotaTableView {
    private Nota nota;
    private Nxenesi nxenesi;
    private Lenda lenda;

    public ProfesoriNotaTableView(Nota nota, Nxenesi nxenesi, Lenda lenda) {
        this.nota = nota;
        this.nxenesi = nxenesi;
        this.lenda = lenda;
    }

    public Nota getNota() {
        return nota;
    }

    public Nxenesi getNxenesi() {
        return nxenesi;
    }

    public Lenda getLenda() {
        return lenda;
    }
}
