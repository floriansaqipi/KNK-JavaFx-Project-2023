package com.example.knk_project.services;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.repositories.AdminiRepository;
import com.example.knk_project.repositories.interfaces.AdminiRepositoryInterface;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.interfaces.AdminiServiceInterface;

import java.sql.SQLException;

public class AdminiService implements AdminiServiceInterface {
    private AdminiRepositoryInterface adminiRepository = new AdminiRepository();

    @Override
    public void signUp(CreateAdminiDto createAdminiDto)
            throws SQLException, UserAlreadyExistsException
    {

        String username = createAdminiDto.getUsername();
        if(this.adminiRepository.getAdminiByUsername(username) != null){
            throw new UserAlreadyExistsException("Username already taken!");
        }
        this.adminiRepository.insert(createAdminiDto);
    }

    @Override
    public void logIn(String username, String password)
            throws UserNotFoundException, IncorrectPasswordException,SQLException {
        Admini admini = this.adminiRepository.getAdminiByUsername(username);
        if(admini == null){
            throw new UserNotFoundException("User does not exist");
        }

        boolean isPasswordCorrect =
                PasswordHasher.compareSaltedHash(password, admini.getSalt(), admini.getSaltedPassword());
        if(!isPasswordCorrect){
            throw new IncorrectPasswordException("Incorrect password");
        }
    }
}
