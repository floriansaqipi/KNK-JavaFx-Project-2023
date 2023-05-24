package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.ProfesoriKlasa;

import java.sql.SQLException;

public interface ProfesoriKlasaServiceInterface {
    void insert(ProfesoriKlasa profesoriKlasa) throws SQLException;
}
