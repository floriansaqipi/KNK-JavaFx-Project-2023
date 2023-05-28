package com.example.knk_project.models;

public class KomunaShtetiTableView {
   private Komuna komuna;
   private Shteti shteti;

    public KomunaShtetiTableView(Komuna komuna, Shteti shteti) {
        this.komuna = komuna;
        this.shteti = shteti;
    }

    public Komuna getKomuna() {
        return komuna;
    }

    public Shteti getShteti() {
        return shteti;
    }
}
