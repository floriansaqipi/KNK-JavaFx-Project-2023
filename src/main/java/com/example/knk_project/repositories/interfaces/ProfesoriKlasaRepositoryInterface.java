package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriKlasaRepositoryInterface {
    void insert(ProfesoriKlasa profesoriKlasa) throws SQLException;


    List<ProfesoriKlasa> getAllProfesoriKlasat() throws SQLException;

    void delete(ProfesoriKlasa profesoriKlasa) throws SQLException;

    void update(UpdateProfesoriKlasaDto updateProfesoriKlasaDto) throws SQLException;

    ProfesoriKlasa getProfesorKlasaById(ProfesoriKlasa profesoriKlasa) throws SQLException;
}
