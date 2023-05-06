package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KlasaRepository implements KlasaRepositoryInterface {
    @Override
    public void insert(CreateKlasaDto createKlasaDto) throws SQLException {
        String sql = "INSERT INTO klasat(klasa, paralelja, viti) VALUES (?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,createKlasaDto.getKlasa());
        preparedStatement.setInt(2,createKlasaDto.getParalelja());
        preparedStatement.setInt(3,createKlasaDto.getViti());

        preparedStatement.executeUpdate();

    }
}
