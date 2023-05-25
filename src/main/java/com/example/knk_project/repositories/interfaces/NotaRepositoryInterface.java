package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateNotaDto;

import java.sql.SQLException;
import java.util.List;

public interface NotaRepositoryInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;

    List<Nota> getAllNotat() throws SQLException;

}
