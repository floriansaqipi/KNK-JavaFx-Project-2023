package com.example.knk_project.services;

import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.repositories.ProfesoriKlasaRepository;
import com.example.knk_project.repositories.interfaces.ProfesoriKlasaRepositoryInterface;
import com.example.knk_project.services.interfaces.ProfesoriKlasaServiceInterface;

import java.sql.SQLException;

public class ProfesoriKlasaService implements ProfesoriKlasaServiceInterface {
    private ProfesoriKlasaRepositoryInterface profesoriKlasaRepository = new ProfesoriKlasaRepository();
    @Override
    public void insert(ProfesoriKlasa profesoriKlasa) throws SQLException {
        this.profesoriKlasaRepository.insert(profesoriKlasa);
    }
}
