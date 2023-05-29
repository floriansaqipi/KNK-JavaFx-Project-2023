package com.example.knk_project.services;

import com.example.knk_project.models.*;
import com.example.knk_project.models.dto.UpdateProfesoriLendaDto;
import com.example.knk_project.repositories.LendaRepository;
import com.example.knk_project.repositories.ProfesoriLendaRepository;
import com.example.knk_project.repositories.ProfesoriRepository;
import com.example.knk_project.repositories.interfaces.LendaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.ProfesoriLendaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.interfaces.ProfesoriLendaServiceInterface;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ProfesoriLendaService implements ProfesoriLendaServiceInterface {
    private ProfesoriLendaRepositoryInterface profesoriLendaRepository = new ProfesoriLendaRepository();
    private ProfesoriRepositoryInterface profesoriRepository = new ProfesoriRepository();
    private LendaRepositoryInterface lendaRepository = new LendaRepository();
    @Override
    public void insert(ProfesoriLenda profesoriLenda) throws SQLException {
        this.profesoriLendaRepository.insert(profesoriLenda);
    }

    @Override
    public void delete(ProfesoriLenda profesoriLenda) throws SQLException {
        this.profesoriLendaRepository.delete(profesoriLenda);
    }

    @Override
    public void addDataToProfesorLendaDataList(ObservableList<AdminProfesorLendaTableView> profesorLendaDataList) throws SQLException {
        profesorLendaDataList.clear();
        List<ProfesoriLenda> profesoriLendet = this.profesoriLendaRepository.getAllProfesoriLendet();
        for (ProfesoriLenda profesoriLenda: profesoriLendet) {
            Profesori profesori = this.profesoriRepository.getProfesoriById(profesoriLenda.getProfesoriId());
            Lenda lenda = this.lendaRepository.getLendaByLendaId(profesoriLenda.getLendaId());
            profesorLendaDataList.add(new AdminProfesorLendaTableView(profesori,lenda));
        }
    }

    @Override
    public List<ProfesoriLenda> getAllProfesorLendet() throws SQLException {
        return null;
    }

    @Override
    public void update(UpdateProfesoriLendaDto updateProfesoriLendaDto) throws SQLException {
        this.profesoriLendaRepository.update(updateProfesoriLendaDto);
    }
}
