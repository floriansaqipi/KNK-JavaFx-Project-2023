package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KlasaRepository implements KlasaRepositoryInterface {
    @Override
    public void insert(CreateKlasaDto createKlasaDto) throws SQLException {
        String sql = "INSERT INTO klasat(klasa, paralelja, viti) VALUES (?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,createKlasaDto.getKlasa());
        preparedStatement.setInt(2,createKlasaDto.getParalelja());
        preparedStatement.setString(3,createKlasaDto.getViti());

        preparedStatement.executeUpdate();

    }

    @Override
    public List<Klasa> getAllKlasat() throws SQLException {
        String sql = "SELECT * FROM klasat;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Klasa> klasat = new ArrayList<>();

        while (resultSet.next()){
            klasat.add(
                    new Klasa(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)
                    )
            );
        }
        return klasat;
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
