package com.example.knk_project.services;

import com.example.knk_project.models.Nota;
import com.example.knk_project.models.User;
import com.example.knk_project.repositories.AdminDashboardRepository;
import com.example.knk_project.repositories.KlasaRepository;
import com.example.knk_project.repositories.interfaces.AdminDashboardRepositoryInterface;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.services.interfaces.AdminDashboardServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class AdminDashboardService implements AdminDashboardServiceInterface {
    private AdminDashboardRepositoryInterface adminDashboardRepository = new AdminDashboardRepository();
    @Override
    public List<User> getAllUsers() throws SQLException {
        return this.adminDashboardRepository.getAllUsers();
    }

    @Override
    public List<User> getAllUsersNxenes() throws SQLException {
        return this.adminDashboardRepository.getAllUsersNxenes();
    }

    @Override
    public List<User> getAllUsersProfesor() throws SQLException {
        return this.adminDashboardRepository.getAllUsersProfesor();
    }


}
