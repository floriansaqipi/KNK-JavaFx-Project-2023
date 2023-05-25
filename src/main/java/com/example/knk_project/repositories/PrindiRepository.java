package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.repositories.interfaces.PrindiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrindiRepository implements PrindiRepositoryInterface {
    @Override
    public void insert(CreatePrindiDto createPrindiDto) throws SQLException {
        String sql = "INSERT INTO prinderit (emri, mbiemri, profesioni, adresa, numri_telefonit, email)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,createPrindiDto.getEmri());
        statement.setString(2,createPrindiDto.getMbiemri());
        statement.setString(3,createPrindiDto.getProfesioni());
        statement.setString(4,createPrindiDto.getAdresa());
        statement.setString(5,createPrindiDto.getNumriTelefonit());
        statement.setString(6,createPrindiDto.getEmail());

        statement.executeUpdate();
    }

    @Override
    public int getLastInsertedId() throws SQLException {
        String sql = "SELECT LAST_INSERT_ID() as lastId";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        if(!resultSet.next()){
            return -1;
        }
        return resultSet.getInt("lastId");

    }
}
