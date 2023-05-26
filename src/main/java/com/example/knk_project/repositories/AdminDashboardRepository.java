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
        String sql = "SELECT * FROM combined_view;";
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

    @Override
    public int getNumberOfGrades() throws SQLException {
        String sql = "SELECT COUNT(*) FROM notat;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfGrades = 0;

        while (resultSet.next()){
            numberOfGrades = resultSet.getInt(1);
        }
        return numberOfGrades ;
    }

    @Override
    public int getNumberOfNxenesve() throws SQLException {
        String sql = "SELECT COUNT(*) FROM nxenesit;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfNxenseve = 0;

        while (resultSet.next()){
            numberOfNxenseve = resultSet.getInt(1);
        }
        return numberOfNxenseve ;
    }

    @Override
    public int getNumberOfProfesoreve() throws SQLException {
        String sql = "SELECT COUNT(*) FROM profesoret;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfProfesoreve = 0;

        while (resultSet.next()){
            numberOfProfesoreve = resultSet.getInt(1);
        }
        return numberOfProfesoreve ;
    }

    @Override
    public int getNumberOfKlaseve() throws SQLException {
        String sql = "SELECT COUNT(*) FROM klasat;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfKlasave = 0;

        while (resultSet.next()){
            numberOfKlasave = resultSet.getInt(1);
        }
        return numberOfKlasave ;
    }
}
