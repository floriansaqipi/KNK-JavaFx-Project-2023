package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminDashboardRepositoryInterface {
    List<User> getAllUsers() throws SQLException;


}

