package com.example.knk_project.repositories;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.models.dto.UpdateKomunaDto;
import com.example.knk_project.models.dto.UpdateShtetiDto;
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

    @Override
    public void deleteShtetiByShtetiId(int shtetiID) throws SQLException {
        String sql = "DELETE FROM shtetet sh WHERE sh.id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, shtetiID);
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(UpdateShtetiDto updateShtetiDto) throws SQLException {
        String sql = "UPDATE shtetet sh SET sh.emri = ? WHERE sh.id = ?;";

        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,updateShtetiDto.getEmri());
        preparedStatement.setInt(2,updateShtetiDto.getId());

        preparedStatement.executeUpdate();
    }
}
