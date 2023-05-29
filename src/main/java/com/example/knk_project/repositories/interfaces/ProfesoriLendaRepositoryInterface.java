package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriLendaDto;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriLendaRepositoryInterface {
    void insert(ProfesoriLenda profesoriLenda) throws SQLException;

    void delete(ProfesoriLenda profesoriLenda) throws SQLException;

    List<ProfesoriLenda> getAllProfesoriLendet() throws SQLException;

    void update(UpdateProfesoriLendaDto updateProfesoriLendaDto) throws SQLException;
}
