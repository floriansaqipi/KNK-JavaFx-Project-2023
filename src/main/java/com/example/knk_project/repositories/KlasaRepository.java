package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;
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

    public List<Klasa> getAllKlasatByProfesorId(int profesoriId) throws SQLException {

        String sql = "SELECT k.* FROM klasat k INNER JOIN profesoret_klasat pk ON k.id = pk.klasa_id " +
                "WHERE pk.profesori_id = ? ; ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriId);

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
    public Klasa getKlasaByNxenesiId(int nxenesiId) throws SQLException {
        String sql = "SELECT k.* FROM klasat k INNER JOIN nxenesit n ON k.id = n.klasa_id " +
                "WHERE n.id = ? ; ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,nxenesiId);

        ResultSet resultSet = preparedStatement.executeQuery();

        Klasa klasa = null;

        if (resultSet.next()){
            klasa =
                    new Klasa(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)
                    );

        }

        return klasa;
    }

    @Override
    public Klasa getKlasaByKlasaId(int klasaId) throws SQLException {
        String sql = "SELECT * FROM klasat k WHERE k.id = ? ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,klasaId);

        ResultSet resultSet = preparedStatement.executeQuery();

        Klasa klasa = null;

        if (resultSet.next()){
            klasa =
                    new Klasa(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)
                    );

        }
        return klasa;
    }

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
