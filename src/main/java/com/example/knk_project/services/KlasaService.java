package com.example.knk_project.services;

import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.repositories.KlasaRepository;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;

import java.sql.SQLException;

public class KlasaService implements KlasaServiceInterface {
    private KlasaRepositoryInterface klasaRepository = new KlasaRepository();
    @Override
    public void register(CreateKlasaDto createKlasaDto) throws SQLException {
        this.klasaRepository.insert(createKlasaDto);
    }
}
