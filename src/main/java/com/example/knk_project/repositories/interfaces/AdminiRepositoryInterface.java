package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.services.AdminiService;

import java.sql.SQLException;

public interface AdminiRepositoryInterface {
    public void insert(CreateAdminiDto createAdminiDto) throws SQLException;
    public Admini getAdminiByUsername(String username) throws SQLException;


}
