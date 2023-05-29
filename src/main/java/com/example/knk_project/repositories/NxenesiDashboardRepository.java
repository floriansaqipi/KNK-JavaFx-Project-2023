package com.example.knk_project.repositories;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.NxenesiDashboardTableView;
import com.example.knk_project.models.Shteti;
import com.example.knk_project.repositories.interfaces.NxenesiDashboardRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;
import com.example.knk_project.services.NxenesiDashboardService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NxenesiDashboardRepository implements NxenesiDashboardRepositoryInterface {

    @Override
    public List<NxenesiDashboardTableView> getNxenesiDashboardTableView(int studentiID) throws SQLException {
        String sql = "SELECT * from nxenesi_dashboard where id = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,studentiID);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<NxenesiDashboardTableView> data = new ArrayList<>();


        while (resultSet.next()){
            data.add(
                    new NxenesiDashboardTableView(
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return data;
    }


    @Override
    public List<NxenesiDashboardTableView> filterNotatByValue(int gradeValue) throws SQLException {
        String sql = "SELECT * FROM nxenesi_dashboard where vlera = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,gradeValue);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<NxenesiDashboardTableView> data = new ArrayList<>();


        while (resultSet.next()){
            data.add(
                    new NxenesiDashboardTableView(
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return data;
    }

    @Override
    public List<NxenesiDashboardTableView> filterNotatBySubject(String subjectName) throws SQLException {
        String sql = "SELECT * FROM nxenesi_dashboard where emri = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,subjectName);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<NxenesiDashboardTableView> data = new ArrayList<>();


        while (resultSet.next()){
            data.add(
                    new NxenesiDashboardTableView(
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return data;
    }

}
