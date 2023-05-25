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
        System.out.println(admini.getSalt());
        System.out.println();
        System.out.println(admini.getSaltedPassword());


        PasswordHasher.compareSaltedHash("test1234", "iNZVxddlhIpenow8RUvmA4g+/pUwuIu3Ab/iAMywwIY=", "694e5a567864646c684970656e6f77385255766d4134672b2f7055777549753341622f69414d79777749593dfda192696795505bfe4dcc4adf1e92f8d469cb5f419709297248aeb46b878fe0");

        boolean isPasswordCorrect =
                PasswordHasher.compareSaltedHash(password, admini.getSalt(), admini.getSaltedPassword());
        if(!isPasswordCorrect){
            throw new IncorrectPasswordException("Incorrect password");
        }
    }
}
