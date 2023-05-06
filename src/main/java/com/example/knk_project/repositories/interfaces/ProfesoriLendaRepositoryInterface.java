package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.profesoriLenda;

import java.sql.SQLException;

public interface ProfesoriLendaRepositoryInterface {
    void insert(profesoriLenda profesoriLenda) throws SQLException;
}
