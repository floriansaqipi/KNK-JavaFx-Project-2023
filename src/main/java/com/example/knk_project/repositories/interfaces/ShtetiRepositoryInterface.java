package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateShtetiDto;

import java.sql.SQLException;
import java.util.List;

public interface ShtetiRepositoryInterface {
    void insert(CreateShtetiDto createShtetiDto) throws SQLException;
    List<Shteti> getAllShtetet() throws SQLException;


}
