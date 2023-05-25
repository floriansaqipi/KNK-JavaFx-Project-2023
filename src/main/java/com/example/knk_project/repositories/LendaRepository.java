package com.example.knk_project.repositories;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.repositories.interfaces.LendaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LendaRepository implements LendaRepositoryInterface {
    @Override
    public void insert(CreateLendaDto createLendaDto) throws SQLException {
        String sql = "INSERT INTO lendet(emri) VALUES (?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createLendaDto.getEmri());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Lenda> getAllLendet() throws SQLException {
        String sql = "SELECT * FROM lendet;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Lenda> lendet = new ArrayList<>();

        while (resultSet.next()){
            lendet.add(
                    new Lenda(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    )
            );
        }
        return lendet;

    }
}
