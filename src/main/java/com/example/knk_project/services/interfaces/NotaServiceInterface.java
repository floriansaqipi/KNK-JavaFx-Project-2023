package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.models.dto.CreateNotaDto;

import java.sql.SQLException;
import java.util.List;

public interface NotaServiceInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;

    public List<Nota> getAllNotat() throws SQLException;
}
