package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateLendaDto;

import java.sql.SQLException;

public interface LendaRepositoryInterface {
    void insert(CreateLendaDto createLendaDto) throws SQLException;
}
