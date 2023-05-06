package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.repositories.interfaces.LendaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LendaRepository implements LendaRepositoryInterface {
    @Override
    public void insert(CreateLendaDto createLendaDto) throws SQLException {
        String sql = "INSERT INTO klasat(emri) VALUES (?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createLendaDto.getEmri());

        preparedStatement.executeUpdate();
    }
}
