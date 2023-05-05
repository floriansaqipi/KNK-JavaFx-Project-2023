package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.UserNotFoundException;

import java.sql.SQLException;

public interface AdminiServiceInterface {
    public void signUp(CreateAdminiDto createAdminiDto)
            throws SQLException, UserAlreadyExistsException;
    public void logIn(String username, String password) throws
            UserNotFoundException, IncorrectPasswordException,SQLException;
}
