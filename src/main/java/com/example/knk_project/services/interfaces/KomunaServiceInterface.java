package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateKomunaDto;

import java.sql.SQLException;

public interface KomunaServiceInterface {
    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
}
