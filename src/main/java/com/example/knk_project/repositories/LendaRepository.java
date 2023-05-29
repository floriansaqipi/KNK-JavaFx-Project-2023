package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
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

    @Override
    public List<Lenda> getAllLendetByProfesoriId(int profesoriId) throws SQLException {
        String sql = "SELECT l.* FROM lendet l INNER JOIN profesoret_lendet pl ON l.id = pl.lenda_id WHERE " +
                " pl.profesori_id =  ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriId);

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

    @Override
    public Lenda getLendaByLendaId(int lendaId) throws SQLException {
        String sql = "SELECT * FROM lendet l WHERE l.id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,lendaId);

        ResultSet resultSet = preparedStatement.executeQuery();

        Lenda lenda = null;

        if (resultSet.next()){
            lenda =
                    new Lenda(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    );

        }
        return lenda;
    }

    @Override
    public int getNumberOfLendeveOfNxenesi(int nxenesiID) throws SQLException {
        String sql = "SELECT COUNT(DISTINCT lenda_id) AS num_lendet " +
                "FROM notat " +
                "WHERE nxenesi_id = ?;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,nxenesiID);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfLendeve = 0;

        while (resultSet.next()){
            numberOfLendeve = resultSet.getInt(1);
        }
        return numberOfLendeve ;
    }
}
