package com.example.knk_project.services;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.UpdateKomunaDto;
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
    public List<KomunaShtetiTableView> getKomunaShtetiTable() throws SQLException {
        return this.komunaRepository.getKomunaShtetiTable();
    }

    @Override
    public void deleteKomunaByKomunaId(int komunaID) throws SQLException {
        this.komunaRepository.deleteKomunaByKomunaId(komunaID);
    }

    @Override
    public void update(UpdateKomunaDto updateKomunaDto) throws SQLException {
        this.komunaRepository.update(updateKomunaDto);
    }

}
