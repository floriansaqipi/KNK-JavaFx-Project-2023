package com.example.knk_project.services;

import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.repositories.ProfesoriRepository;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class ProfesoriService implements ProfesoriServiceInterface {
    private ProfesoriRepositoryInterface profesoriRepository = new ProfesoriRepository();

    @Override
    public void signUp(CreateProfesoriDto createProfesoriDto)
            throws SQLException, UserAlreadyExistsException
    {

        String username = createProfesoriDto.getUsername();
        if(this.profesoriRepository.getProfesoriByUsername(username) != null){
            throw new UserAlreadyExistsException("Username already taken!");
        }
        this.profesoriRepository.insert(createProfesoriDto);
    }

    @Override
    public void logIn(String username, String password)
            throws UserNotFoundException, IncorrectPasswordException,SQLException {
        Profesori Profesori = this.profesoriRepository.getProfesoriByUsername(username);
        if(Profesori == null){
            throw new UserNotFoundException("User does not exist");
        }
        boolean isPasswordCorrect =
                PasswordHasher.compareSaltedHash(password, Profesori.getSalt(), Profesori.getSaltedPassword());
        if(!isPasswordCorrect){
            throw new IncorrectPasswordException("Incorrect password");
        }
    }

    @Override
    public List<Profesori> getAllProfesoret() throws SQLException {
        return this.profesoriRepository.getAllProfesoret();
    }


    @Override
    public Profesori getProfesorByUsername(String username) throws SQLException {
        return this.profesoriRepository.getProfesoriByUsername(username);
    }

    @Override
    public Profesori getProfesorById(int profesoriId) throws SQLException {
        return  this.profesoriRepository.getProfesoriById(profesoriId);

    @Override
    public int getNumberOfProfesoreve() throws SQLException {
        return this.profesoriRepository.getNumberOfProfesoreve();

    }
}
