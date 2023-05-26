package com.example.knk_project.services;

import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.repositories.NotaRepository;
import com.example.knk_project.repositories.interfaces.NotaRepositoryInterface;
import com.example.knk_project.services.interfaces.NotaServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class NotaService implements NotaServiceInterface {
    private NotaRepositoryInterface notaRepository = new NotaRepository();
    @Override
    public void insert(CreateNotaDto createNotaDto) throws SQLException {
        this.notaRepository.insert(createNotaDto);

    }

    @Override
    public List<Nota> getAllNotat() throws SQLException{
        return this.notaRepository.getAllNotat();
    }

    @Override
    public int getNumberOfGrades() throws SQLException {
        return this.notaRepository.getNumberOfGrades();
    }

}
