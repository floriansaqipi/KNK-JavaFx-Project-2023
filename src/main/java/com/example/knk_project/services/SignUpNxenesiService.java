package com.example.knk_project.services;

import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.repositories.NxenesiRepository;
import com.example.knk_project.repositories.PrindiRepository;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.repositories.interfaces.PrindiRepositoryInterface;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.interfaces.SignUpNxenesiServiceInterface;

import java.sql.SQLException;

public class SignUpNxenesiService implements SignUpNxenesiServiceInterface {
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
}
