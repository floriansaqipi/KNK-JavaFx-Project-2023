package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesoriRepository implements ProfesoriRepositoryInterface {
    @Override
    public void insert(CreateProfesoriDto createProfesoriDto) throws SQLException {
        String sql = "INSERT INTO profesoret (username, salt, salted_password, emri, mbiemri, titulli)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,createProfesoriDto.getUsername());
        statement.setString(2,createProfesoriDto.getSalt());
        statement.setString(3,createProfesoriDto.getSaltedPassword());
        statement.setString(4,createProfesoriDto.getEmri());
        statement.setString(5,createProfesoriDto.getMbiemri());
        statement.setString(6,createProfesoriDto.getTitulli());

        statement.executeUpdate();
    }
}
