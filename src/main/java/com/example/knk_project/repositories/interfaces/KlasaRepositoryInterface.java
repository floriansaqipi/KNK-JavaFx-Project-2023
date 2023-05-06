package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateKlasaDto;

import java.sql.SQLException;

public interface KlasaRepositoryInterface {
    void insert(CreateKlasaDto createKlasaDto) throws SQLException;

}
