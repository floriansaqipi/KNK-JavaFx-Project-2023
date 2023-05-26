package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Nota;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateNxenesiDto;

import java.sql.SQLException;
import java.util.List;

public interface NxenesiRepositoryInterface {
    public void insert(CreateNxenesiDto createNxenesiDto) throws SQLException;
    public Nxenesi getNxenesiByUsername(String username) throws SQLException;

    List<Nxenesi> getAllNxenesitbyProfesoriID(int profesoriID) throws SQLException;

    List<Nxenesi> getAllNxenesitByKlasaId(int klasaId) throws SQLException;
}
