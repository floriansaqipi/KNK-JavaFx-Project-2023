package com.example.knk_project.repositories;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.models.dto.UpdateKomunaDto;
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
    public  List<KomunaShtetiTableView> getKomunaShtetiTable() throws SQLException {
        String sql = "SELECT k.id, k.emri, k.shteti_id, sh.emri FROM komunat k INNER JOIN shtetet sh ON k.shteti_id = sh.id ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<KomunaShtetiTableView> komunat_shtetet = new ArrayList<>();

        while (resultSet.next()){
            komunat_shtetet.add(
                    new KomunaShtetiTableView(
                            new Komuna(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getInt(3)
                            ),
                            new Shteti(
                                    resultSet.getInt(3),
                                    resultSet.getString(4)
                            )
                    )
            );
        }
        return komunat_shtetet;
    }

    @Override
    public void deleteKomunaByKomunaId(int komunaID) throws SQLException {
        String sql = "DELETE FROM komunat k WHERE k.id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, komunaID);
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(UpdateKomunaDto updateKomunaDto) throws SQLException {
        String sql = "UPDATE komunat k SET k.emri = ?, k.shteti_id = ? WHERE k.id = ?;";

        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,updateKomunaDto.getEmri());
        preparedStatement.setInt(2,updateKomunaDto.getShteti_id());
        preparedStatement.setInt(3,updateKomunaDto.getId());

        preparedStatement.executeUpdate();
    }

}
