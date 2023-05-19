package com.example.knk_project.repositories;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.repositories.interfaces.ShtetiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShtetiRepository implements ShtetiRepositoryInterface {
    @Override
    public void insert(CreateShtetiDto createShtetiDto) throws SQLException {
        String sql = "INSERT INTO shtetet(emri) VALUES (?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createShtetiDto.getEmri());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Shteti> getAllShtetet() throws SQLException {
        String sql = "SELECT * FROM shtetet;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Shteti> shtetet = new ArrayList<>();

        while (resultSet.next()){
            shtetet.add(new Shteti(resultSet.getInt(1),resultSet.getString(2)));
        }
        return shtetet;

    }
}
