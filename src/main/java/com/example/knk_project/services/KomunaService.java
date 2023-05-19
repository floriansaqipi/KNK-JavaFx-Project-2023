package com.example.knk_project.services;

import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.repositories.KomunaRepository;
import com.example.knk_project.repositories.interfaces.KomunaRepositoryInterface;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;

import java.sql.SQLException;

public class KomunaService implements KomunaServiceInterface {
    private KomunaRepositoryInterface komunaRepository = new KomunaRepository();
    @Override
    public void insert(CreateKomunaDto createKomunaDto) throws SQLException {
        this.komunaRepository.insert(createKomunaDto);
    }
}
