package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;

import java.sql.SQLException;
import java.util.List;

public interface NotaRepositoryInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;

    List<Nota> getAllNotat() throws SQLException;
    int getNumberOfGrades() throws SQLException;

    List<Nota> getAllNotatByProfesoriId(int profesoriId) throws SQLException;

    void deleteNotaByNotaId(int notaId) throws SQLException;

    void update(UpdateNotaDto updateNotaDto) throws SQLException;

}
