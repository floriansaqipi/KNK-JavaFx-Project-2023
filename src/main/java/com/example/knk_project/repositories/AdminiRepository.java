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
        String sql = "INSERT INTO admin(username, salt, salted_password) VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, createAdminiDto.getUsername());
        statement.setString(2, createAdminiDto.getSalt());
        statement.setString(3, createAdminiDto.getSaltedPassword());

        statement.executeUpdate();
    }
}
