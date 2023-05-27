package com.example.knk_project.services;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShteti;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.CreateUpdatedKomunaDto;
import com.example.knk_project.repositories.KomunaRepository;
import com.example.knk_project.repositories.interfaces.KomunaRepositoryInterface;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class KomunaService implements KomunaServiceInterface {
    private KomunaRepositoryInterface komunaRepository = new KomunaRepository();
    @Override
    public void insert(CreateKomunaDto createKomunaDto) throws SQLException {
        this.komunaRepository.insert(createKomunaDto);
    }

    @Override
    public List<Komuna> getAllKomunat() throws SQLException {
        return this.komunaRepository.getAllKomunat();
    }

    @Override
    public List<KomunaShteti> getKomunaShtetiTable() throws SQLException {
        return this.komunaRepository.getKomunaShtetiTable();
    }

    @Override
    public void updateKomuna(CreateUpdatedKomunaDto createUpdatedKomunaDto) throws SQLException {
        this.komunaRepository.updateKomuna(createUpdatedKomunaDto);
    }
}
