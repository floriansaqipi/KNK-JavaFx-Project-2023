package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateShtetiDto;

import java.sql.SQLException;

public interface ShtetiServiceInterface {
    void register(CreateShtetiDto createShtetiDto) throws SQLException;
}
