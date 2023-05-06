package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.repositories.interfaces.ShtetiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShtetiRepository implements ShtetiRepositoryInterface {
    @Override
    public void insert(CreateShtetiDto createShtetiDto) throws SQLException {
        String sql = "INSERT INTO shtetet(emri) VALUES (?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createShtetiDto.getEmri());

        preparedStatement.executeUpdate();
    }
}
