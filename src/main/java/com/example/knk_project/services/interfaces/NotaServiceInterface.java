package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.ProfesoriNotaTableView;
import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface NotaServiceInterface {
    void insert(CreateNotaDto createNotaDto) throws SQLException;

     List<Nota> getAllNotat() throws SQLException;
    int getNumberOfGrades() throws SQLException;

    void addDataToGradesDataList(ObservableList<ProfesoriNotaTableView> gradesDatalist, int profesoriId) throws SQLException;

    void deleteNotaByNotaId(int notaId) throws SQLException;

    void update(UpdateNotaDto updateNotaDto) throws SQLException;
}
