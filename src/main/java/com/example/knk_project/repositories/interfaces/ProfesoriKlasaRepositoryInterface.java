package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.ProfesoriKlasa;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriKlasaRepositoryInterface {
    void insert(ProfesoriKlasa profesoriKlasa) throws SQLException;


}
