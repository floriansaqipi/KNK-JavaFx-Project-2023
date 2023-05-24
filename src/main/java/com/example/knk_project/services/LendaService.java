package com.example.knk_project.services;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.repositories.LendaRepository;
import com.example.knk_project.repositories.interfaces.LendaRepositoryInterface;
import com.example.knk_project.services.interfaces.LendaServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class LendaService implements LendaServiceInterface {
    private LendaRepositoryInterface lendaRepository = new LendaRepository();
    @Override
    public void insert(CreateLendaDto createLendaDto) throws SQLException {
        this.lendaRepository.insert(createLendaDto);

    }

    @Override
    public List<Lenda> getAllLendet() throws SQLException{
        return this.lendaRepository.getAllLendet();
    }

}
