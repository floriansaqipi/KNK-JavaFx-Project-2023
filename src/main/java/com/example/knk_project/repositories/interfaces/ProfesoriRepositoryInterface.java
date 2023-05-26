package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateProfesoriDto;

import java.sql.SQLException;
import java.util.List;

public interface ProfesoriRepositoryInterface {
    public void insert(CreateProfesoriDto createProfesoriDto) throws SQLException;
    public Profesori getProfesoriByUsername(String username) throws SQLException;
    public Profesori getProfesoriById(int profesoriId) throws SQLException;

    public List<Profesori> getAllProfesoret() throws SQLException;
    int getNumberOfProfesoreve() throws SQLException;
}
