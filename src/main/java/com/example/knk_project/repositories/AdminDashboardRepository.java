package com.example.knk_project.repositories;

import com.example.knk_project.models.User;
import com.example.knk_project.repositories.interfaces.AdminDashboardRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboardRepository implements AdminDashboardRepositoryInterface {
    @Override
    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            users.add(
                    new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return users;
    }
}
