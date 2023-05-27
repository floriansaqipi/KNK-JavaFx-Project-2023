package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.repositories.interfaces.NotaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaRepository implements NotaRepositoryInterface {
    @Override
    public void insert(CreateNotaDto createNotaDto) throws SQLException {
        String sql = "INSERT INTO notat(vlera, rubrika, gjysmevjetori, profesori_id, lenda_id, nxenesi_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,createNotaDto.getVlera());
        preparedStatement.setInt(2,createNotaDto.getRubrika());
        preparedStatement.setInt(3,createNotaDto.getGjysmevjetori());
        preparedStatement.setInt(4,createNotaDto.getProfesoriId());
        preparedStatement.setInt(5,createNotaDto.getLendaId());
        preparedStatement.setInt(6,createNotaDto.getNxenesiId());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Nota> getAllNotat() throws SQLException {
        String sql = "SELECT * FROM notat;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Nota> notat = new ArrayList<>();

        while (resultSet.next()){
            notat.add(
                    new Nota(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7)

                    )
            );
        }
        return notat;
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
    public List<Nota> getAllNotatByProfesoriId(int profesoriId) throws SQLException {
        String sql = "SELECT * FROM notat n WHERE n.profesori_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriId);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Nota> notat = new ArrayList<>();

        while (resultSet.next()){
            notat.add(
                    new Nota(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7)

                    )
            );
        }
        return notat;
    }

}
