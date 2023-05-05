package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;

import java.sql.SQLException;

public interface SignUpNxenesiServiceInterface {
    public void signUp(CreateNxenesiDto createNxenesiDto, CreatePrindiDto createPrindiDto)
            throws SQLException, UserAlreadyExistsException;
}
