package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.UpdateKomunaDto;

import java.sql.SQLException;
import java.util.List;

public interface KomunaServiceInterface {
    void insert(CreateKomunaDto createKomunaDto) throws SQLException;
     List<Komuna> getAllKomunat() throws SQLException;
     List<KomunaShtetiTableView> getKomunaShtetiTable() throws SQLException;
    void deleteKomunaByKomunaId(int komunaID) throws SQLException;
    void update(UpdateKomunaDto updateKomunaDto) throws SQLException;

}
