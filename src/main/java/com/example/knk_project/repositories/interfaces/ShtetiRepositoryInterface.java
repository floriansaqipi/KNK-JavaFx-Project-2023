package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateShtetiDto;

import java.sql.SQLException;

public interface ShtetiRepositoryInterface {
    void insert(CreateShtetiDto createShtetiDto) throws SQLException;

}
