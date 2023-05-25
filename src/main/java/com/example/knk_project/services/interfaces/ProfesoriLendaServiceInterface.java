package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.ProfesoriLenda;

import java.sql.SQLException;

public interface ProfesoriLendaServiceInterface {
    void insert(ProfesoriLenda profesoriLenda) throws SQLException;
}
