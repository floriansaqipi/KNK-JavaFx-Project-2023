package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateShtetiDto;

import java.sql.SQLException;
import java.util.List;

public interface ShtetiServiceInterface {
    void register(CreateShtetiDto createShtetiDto) throws SQLException;

    List<Shteti> getAllShtetet() throws SQLException;
}
