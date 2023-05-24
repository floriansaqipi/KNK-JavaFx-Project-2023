package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.ProfesoriLenda;

import java.sql.SQLException;

public interface ProfesoriLendaRepositoryInterface {
    void insert(ProfesoriLenda profesoriLenda) throws SQLException;
}
