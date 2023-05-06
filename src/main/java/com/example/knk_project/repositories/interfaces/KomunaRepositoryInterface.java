package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateKomunaDto;

import java.sql.SQLException;

public interface KomunaRepositoryInterface {


    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
}
