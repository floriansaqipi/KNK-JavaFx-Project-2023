package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShteti;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.CreateUpdatedKomunaDto;

import java.sql.SQLException;
import java.util.List;

public interface KomunaServiceInterface {
    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
    public List<Komuna> getAllKomunat() throws SQLException;
    public List<KomunaShteti> getKomunaShtetiTable() throws SQLException;
    void updateKomuna(CreateUpdatedKomunaDto createUpdatedKomunaDto) throws SQLException;


}
