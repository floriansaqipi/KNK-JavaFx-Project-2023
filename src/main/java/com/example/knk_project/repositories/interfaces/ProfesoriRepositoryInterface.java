package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateProfesoriDto;

import java.sql.SQLException;

public interface ProfesoriRepositoryInterface {
    public void insert(CreateProfesoriDto createProfesoriDto) throws SQLException;
}
