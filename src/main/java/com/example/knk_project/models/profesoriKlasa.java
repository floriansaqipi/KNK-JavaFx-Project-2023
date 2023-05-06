package com.example.knk_project.models;

public class profesoriKlasa {
    private int profesoriId;
    private int klasaId;

    public profesoriKlasa(int profesoriId, int klasaId) {
        this.profesoriId = profesoriId;
        this.klasaId = klasaId;
    }

    public int getProfesoriId() { return profesoriId; }

    public int getKlasaId() {return klasaId;
    }
}
