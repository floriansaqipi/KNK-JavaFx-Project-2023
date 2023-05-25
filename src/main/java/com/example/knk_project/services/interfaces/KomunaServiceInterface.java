package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateKomunaDto;

import java.sql.SQLException;
import java.util.List;

public interface KomunaServiceInterface {
    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
    public List<Komuna> getAllKomunat() throws SQLException;
}
