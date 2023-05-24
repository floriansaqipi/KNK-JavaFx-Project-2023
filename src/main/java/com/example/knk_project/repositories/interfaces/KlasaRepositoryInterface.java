package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.dto.CreateKlasaDto;

import java.sql.SQLException;
import java.util.List;

public interface KlasaRepositoryInterface {
    void insert(CreateKlasaDto createKlasaDto) throws SQLException;

    List<Klasa> getAllKlasat() throws SQLException;


}
