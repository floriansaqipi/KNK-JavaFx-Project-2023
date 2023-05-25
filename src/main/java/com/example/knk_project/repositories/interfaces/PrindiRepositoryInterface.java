package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Prindi;
import com.example.knk_project.models.dto.CreatePrindiDto;

import java.sql.SQLException;

public interface PrindiRepositoryInterface {
    public void insert(CreatePrindiDto createPrindiDto) throws SQLException;
    public int getLastInsertedId() throws SQLException;
}
