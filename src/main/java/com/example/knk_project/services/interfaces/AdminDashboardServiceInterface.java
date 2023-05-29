package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminDashboardServiceInterface {
    List<User> getAllUsers() throws SQLException;
    List<User> getAllUsersNxenes() throws SQLException;
    List<User> getAllUsersProfesor() throws SQLException;




}
