package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShteti;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.User;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.CreateUpdatedKomunaDto;

import java.sql.SQLException;
import java.util.List;

public interface KomunaRepositoryInterface {
    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
    List<Komuna> getAllKomunat() throws SQLException;
    List<KomunaShteti>  getKomunaShtetiTable() throws SQLException;
    void updateKomuna(CreateUpdatedKomunaDto createUpdatedKomunaDto) throws SQLException;
}
