package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.repositories.interfaces.AdminiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminiRepository implements AdminiRepositoryInterface {

    @Override
    public void insert(CreateAdminiDto createAdminiDto) throws SQLException {
        String sql = "INSERT INTO profesoret(username, salt, salted_password, emri, mbiemri, titulli) VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, createAdminiDto.getUsername());
        statement.setString(2, createAdminiDto.getSalt());
        statement.setString(3, createAdminiDto.getSaltedPassword());
        statement.setString(4, createAdminiDto.getEmri());
        statement.setString(5,createAdminiDto.getMbiemri());
        statement.setString(6, createAdminiDto.getTitulli());

        statement.executeUpdate();
    }
}
