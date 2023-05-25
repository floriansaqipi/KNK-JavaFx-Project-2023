package com.example.knk_project.repositories;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.repositories.interfaces.AdminiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.*;

public class AdminiRepository implements AdminiRepositoryInterface {

    @Override
    public void insert(CreateAdminiDto createAdminiDto) throws SQLException {
        String sql = "INSERT INTO admin(username, salt, salted_password) VALUES (?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println(createAdminiDto.getSalt());
        System.out.println("===============================");
        System.out.println(createAdminiDto.getSaltedPassword());
        statement.setString(1, createAdminiDto.getUsername());
        statement.setString(2, createAdminiDto.getSalt());
        statement.setString(3, createAdminiDto.getSaltedPassword());

        statement.executeUpdate();
    }

    @Override
    public Admini getAdminiByUsername(String usernameValue) throws SQLException {
        String sql = "SELECT * FROM admin n WHERE n.username = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1 , usernameValue);

        ResultSet resultSet = statement.executeQuery();
        if(!resultSet.next()){
            return  null;
        }
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String salt = resultSet.getString("salt");
        String saltedPassword = resultSet.getString("salted_password");
        return new Admini(
                id,
                username,
                salt,
                saltedPassword
        );
    }
}
