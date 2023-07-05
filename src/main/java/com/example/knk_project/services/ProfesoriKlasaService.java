package com.example.knk_project.services;

import com.example.knk_project.models.*;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import com.example.knk_project.repositories.KlasaRepository;
import com.example.knk_project.repositories.LendaRepository;
import com.example.knk_project.repositories.ProfesoriKlasaRepository;
import com.example.knk_project.repositories.ProfesoriRepository;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.ProfesoriKlasaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.exceptions.ProfesorKlasaException;
import com.example.knk_project.services.interfaces.ProfesoriKlasaServiceInterface;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ProfesoriKlasaService implements ProfesoriKlasaServiceInterface {
    private ProfesoriKlasaRepositoryInterface profesoriKlasaRepository = new ProfesoriKlasaRepository();
    private ProfesoriRepositoryInterface profesoriRepository = new ProfesoriRepository();
    private KlasaRepositoryInterface klasaRepository = new KlasaRepository();

    @Override
    public void insert(ProfesoriKlasa profesoriKlasa) throws SQLException, ProfesorKlasaException {
        ProfesoriKlasa profesoriKlasaFound = null;
        profesoriKlasaFound = this.profesoriKlasaRepository.getProfesorKlasaById(profesoriKlasa);
        if(profesoriKlasaFound != null){
            throw new ProfesorKlasaException("Profesor Klasa Exception");
        }
        this.profesoriKlasaRepository.insert(profesoriKlasa);
    }

    @Override
    public void addDataToProfesorKlasaDataList(ObservableList<AdminProfesorKlasaTableView> profesorKlasaDataList) throws SQLException {
        profesorKlasaDataList.clear();
        List<ProfesoriKlasa> profesoriKlasat = this.profesoriKlasaRepository.getAllProfesoriKlasat();
        for (ProfesoriKlasa profesoriKlasa: profesoriKlasat) {
            Profesori profesori = this.profesoriRepository.getProfesoriById(profesoriKlasa.getProfesoriId());
            Klasa klasa = this.klasaRepository.getKlasaByKlasaId(profesoriKlasa.getKlasaId());
            profesorKlasaDataList.add(new AdminProfesorKlasaTableView(profesori,klasa));
        }
    }

    @Override
    public void delete(ProfesoriKlasa profesoriKlasa) throws SQLException {
        this.profesoriKlasaRepository.delete(profesoriKlasa);
    }

    @Override
    public void update(UpdateProfesoriKlasaDto updateProfesoriKlasaDto) throws SQLException, ProfesorKlasaException {
        ProfesoriKlasa profesoriKlasaFound = null;
        ProfesoriKlasa profesoriKlasa = new ProfesoriKlasa(updateProfesoriKlasaDto.getNewProfesoriId(),
                updateProfesoriKlasaDto.getNewKlasaId());
        profesoriKlasaFound = this.profesoriKlasaRepository.getProfesorKlasaById(profesoriKlasa);
        if(profesoriKlasaFound != null){
            throw new ProfesorKlasaException("Profesor Klasa Exception");
        }
        this.profesoriKlasaRepository.update(updateProfesoriKlasaDto);
    }
}
