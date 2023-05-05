package com.example.knk_project.repositories.interfaces;

import java.sql.SQLException;

public interface NotaRepositoryInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;
}
