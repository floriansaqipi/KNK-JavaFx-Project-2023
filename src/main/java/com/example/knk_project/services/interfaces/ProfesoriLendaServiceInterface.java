package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriLendaDto;
import com.example.knk_project.services.exceptions.ProfesorLendaException;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriLendaServiceInterface {
    void insert(ProfesoriLenda profesoriLenda) throws SQLException, ProfesorLendaException;

    void delete(ProfesoriLenda profesoriLenda) throws SQLException;

    void addDataToProfesorLendaDataList(ObservableList<AdminProfesorLendaTableView> profesorLendaDataList) throws SQLException;

    List<ProfesoriLenda> getAllProfesorLendet() throws SQLException;

    void update(UpdateProfesoriLendaDto updateProfesoriLendaDto) throws SQLException, ProfesorLendaException;
}
