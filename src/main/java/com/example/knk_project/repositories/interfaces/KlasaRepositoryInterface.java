package com.example.knk_project.repositories.interfaces;

import java.sql.SQLException;

public interface KlasaRepositoryInterface {
    void insert(CreateKlasaDto createKlasaDto) throws SQLException;
}
