package com.example.knk_project.services;

import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.repositories.ProfesoriLendaRepository;
import com.example.knk_project.repositories.interfaces.ProfesoriLendaRepositoryInterface;
import com.example.knk_project.services.interfaces.ProfesoriLendaServiceInterface;

import java.sql.SQLException;

public class ProfesoriLendaService implements ProfesoriLendaServiceInterface {
    private ProfesoriLendaRepositoryInterface profesoriLendaRepository = new ProfesoriLendaRepository();
    @Override
    public void insert(ProfesoriLenda profesoriLenda) throws SQLException {
        this.profesoriLendaRepository.insert(profesoriLenda);
    }
}
