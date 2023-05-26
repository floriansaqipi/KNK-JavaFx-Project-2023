package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.dto.CreateLendaDto;

import java.sql.SQLException;
import java.util.List;

public interface LendaRepositoryInterface {
    void insert(CreateLendaDto createLendaDto) throws SQLException;

    List<Lenda> getAllLendet() throws SQLException;

    List<Lenda> getAllLendetByProfesoriId(int profesoriId) throws SQLException;

}
