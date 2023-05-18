package com.example.knk_project.services;

import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.repositories.ShtetiRepository;
import com.example.knk_project.repositories.interfaces.ShtetiRepositoryInterface;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;

import java.sql.SQLException;

public class ShtetiService implements ShtetiServiceInterface {
    private ShtetiRepositoryInterface shtetiRepository = new ShtetiRepository();


    @Override
    public void register(CreateShtetiDto createShtetiDto) throws SQLException {
        this.shtetiRepository.insert(createShtetiDto);
    }
}
