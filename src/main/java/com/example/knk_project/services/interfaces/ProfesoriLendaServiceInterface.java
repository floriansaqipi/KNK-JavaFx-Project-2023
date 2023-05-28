package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriLendaServiceInterface {
    void insert(ProfesoriLenda profesoriLenda) throws SQLException;

    void delete(ProfesoriLenda profesoriLenda) throws SQLException;

    void addDataToProfesorLendaDataList(ObservableList<AdminProfesorLendaTableView> profesorLendaDataList) throws SQLException;

    List<ProfesoriLenda> getAllProfesorLendet() throws SQLException;

    void update(UpdateProfesoriKlasaDto updateProfesoriKlasaDto) throws SQLException;
}
