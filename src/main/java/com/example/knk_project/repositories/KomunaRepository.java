package com.example.knk_project.repositories;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShteti;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.User;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.CreateUpdatedKomunaDto;
import com.example.knk_project.repositories.interfaces.KomunaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KomunaRepository implements KomunaRepositoryInterface {
    @Override
    public void insert(CreateKomunaDto createKomunaDto) throws SQLException {
        String sql = "INSERT INTO komunat(emri, shteti_id) VALUES (?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createKomunaDto.getEmri());
        preparedStatement.setInt(2,createKomunaDto.getShtetiId());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Komuna> getAllKomunat() throws SQLException {
        String sql = "SELECT * FROM komunat;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Komuna> komunat = new ArrayList<>();

        while (resultSet.next()){
            komunat.add(
                    new Komuna(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3)
                    )
            );
        }
        return komunat;

    }

    @Override
    public  List<KomunaShteti> getKomunaShtetiTable() throws SQLException {
        String sql = "SELECT k.id, k.emri, k.shteti_id, sh.emri FROM komunat k INNER JOIN shtetet sh ON k.shteti_id = sh.id ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<KomunaShteti> komunat_shtetet = new ArrayList<>();

        while (resultSet.next()){
            komunat_shtetet.add(
                    new KomunaShteti(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)
                    )
            );
        }
        return komunat_shtetet;
    }

    @Override
    public void updateKomuna(CreateUpdatedKomunaDto createUpdatedKomunaDto) throws SQLException {
        String sql = "UPDATE komunat k SET k.emri = ?, k.shteti_id = ? WHERE k.id = ?;";

        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,createUpdatedKomunaDto.getEmri());
        preparedStatement.setInt(2,createUpdatedKomunaDto.getShteti_id());
        preparedStatement.setInt(3,createUpdatedKomunaDto.getId());

        preparedStatement.executeUpdate();
    }

}
