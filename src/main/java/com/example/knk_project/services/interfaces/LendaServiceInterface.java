package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.CreateLendaDto;

import java.sql.SQLException;
import java.util.List;

public interface LendaServiceInterface {
    void insert(CreateLendaDto createLendaDto) throws SQLException;

    public List<Lenda> getAllLendet() throws SQLException;

}
