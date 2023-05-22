package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateKlasaDto;

import java.sql.SQLException;

public interface KlasaServiceInterface {
    public void register(CreateKlasaDto createKlasaDto) throws SQLException;
}
