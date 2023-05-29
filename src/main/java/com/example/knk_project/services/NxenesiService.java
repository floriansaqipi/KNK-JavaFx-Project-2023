package com.example.knk_project.services;

import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.repositories.NxenesiRepository;
import com.example.knk_project.repositories.PrindiRepository;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.repositories.interfaces.PrindiRepositoryInterface;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.interfaces.NxenesiServiceInterface;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;

public class NxenesiService implements NxenesiServiceInterface {
    private NxenesiRepositoryInterface nxenesiRepository = new NxenesiRepository();
    private PrindiRepositoryInterface prindiRepository = new PrindiRepository();
    @Override
    public void signUp(CreateNxenesiDto createNxenesiDto, CreatePrindiDto createPrindiDto)
            throws SQLException, UserAlreadyExistsException
    {

        String username = createNxenesiDto.getUsername();
        if(this.nxenesiRepository.getNxenesiByUsername(username) != null){
            throw new UserAlreadyExistsException("Username already taken!");
        }
        this.prindiRepository.insert(createPrindiDto);
        int prindiId = this.prindiRepository.getLastInsertedId();
        createNxenesiDto.setPrindiId(prindiId);
        this.nxenesiRepository.insert(createNxenesiDto);
    }

    @Override
    public void logIn(String username, String password)
            throws UserNotFoundException, IncorrectPasswordException,SQLException {
        Nxenesi nxenesi = this.nxenesiRepository.getNxenesiByUsername(username);
        if(nxenesi == null){
            throw new UserNotFoundException("User does not exist");
        }
        boolean isPasswordCorrect =
                PasswordHasher.compareSaltedHash(password, nxenesi.getSalt(), nxenesi.getSaltedPassword());
        if(!isPasswordCorrect){
            throw new IncorrectPasswordException("Incorrect password");
        }
    }

    @Override
    public List<Nxenesi> getAllNxenesitbyProfesoriID(int profesoriID) throws SQLException {
        return this.nxenesiRepository.getAllNxenesitbyProfesoriID(profesoriID);
    }


    @Override
    public List<Nxenesi> getAllNxenesitByKlasaId(int klasaId) throws SQLException {
        return this.nxenesiRepository.getAllNxenesitByKlasaId(klasaId);
    }

    @Override
    public Nxenesi getNxenesiByUsername(String username) throws SQLException {
        return this.nxenesiRepository.getNxenesiByUsername(username);
    }

    @Override
    public int getNumberOfNxenesve() throws SQLException {
        return this.nxenesiRepository.getNumberOfNxenesve();

    }
}
