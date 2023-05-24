package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.repositories.interfaces.KomunaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KomunaRepository implements KomunaRepositoryInterface {
    @Override
    public void insert(CreateKomunaDto createKomunaDto) throws SQLException {
        String sql = "INSERT INTO komunat(emri, shteti_id) VALUES (?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createKomunaDto.getEmri());
        preparedStatement.setInt(2,createKomunaDto.getShtetiId());

        preparedStatement.executeUpdate();
    }
}
