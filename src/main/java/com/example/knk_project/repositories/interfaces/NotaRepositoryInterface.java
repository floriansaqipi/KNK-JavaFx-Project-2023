package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateNotaDto;

import java.sql.SQLException;

public interface NotaRepositoryInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;

}
