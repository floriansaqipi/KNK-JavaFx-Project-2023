package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.AdminProfesorKlasaTableView;
import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import com.example.knk_project.services.exceptions.ProfesorKlasaException;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ProfesoriKlasaServiceInterface {
    void insert(ProfesoriKlasa profesoriKlasa) throws SQLException, ProfesorKlasaException;

    void addDataToProfesorKlasaDataList(ObservableList<AdminProfesorKlasaTableView> profesorKlasaDataList) throws SQLException;

    void delete(ProfesoriKlasa profesoriKlasa) throws SQLException;

    void update(UpdateProfesoriKlasaDto updateProfesoriKlasaDto) throws SQLException, ProfesorKlasaException;
}
