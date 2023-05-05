package com.example.knk_project.repositories.interfaces;

import java.sql.SQLException;

public interface LendaRepositoryInterface {
    void insert(CreateLendaDto createLendaDto) throws SQLException;
}
