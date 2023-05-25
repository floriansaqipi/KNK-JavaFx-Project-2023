package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.dto.CreateKlasaDto;

import java.sql.SQLException;
import java.util.List;

public interface KlasaServiceInterface {
    public void register(CreateKlasaDto createKlasaDto) throws SQLException;
    List<Klasa> getAllKlasat() throws SQLException;
}
