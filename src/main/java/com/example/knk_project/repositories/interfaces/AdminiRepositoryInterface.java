package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.models.dto.CreateNxenesiDto;

import java.sql.SQLException;

public interface AdminiRepositoryInterface {
    public void insert(CreateAdminiDto createAdminiDto) throws SQLException;

}
