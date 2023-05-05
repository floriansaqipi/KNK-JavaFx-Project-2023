package com.example.knk_project.repositories;

import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.*;

public class NxenesiRepository implements NxenesiRepositoryInterface {

    @Override
    public void insert(CreateNxenesiDto createNxenesiDto) throws SQLException {
        String sql = "INSERT INTO nxenesit(" +
                "username, salt, salted_password, emri, mbiemri, data_e_lindjes," +
                "vendlindja_id, komuna_id, prindi_id, klasa_id ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, createNxenesiDto.getUsername());
        statement.setString(2, createNxenesiDto.getSalt());
        statement.setString(3, createNxenesiDto.getSaltedPassword());
        statement.setString(4, createNxenesiDto.getEmri());
        statement.setString(5,createNxenesiDto.getMbiemri());
        statement.setDate(6, (Date) createNxenesiDto.getDataLindjes());
        statement.setInt(7,createNxenesiDto.getVendLindjaId());
        statement.setInt(8,createNxenesiDto.getKomunaId());
        statement.setInt(9,createNxenesiDto.getPrindiId());
        statement.setInt(10,createNxenesiDto.getKlasaId());

        statement.executeUpdate();
    }

    @Override
    public Nxenesi getNxenesiByUsername(String usernameValue) throws SQLException {
        String sql = "SELECT * FROM nxenesit n WHERE n.username = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1 , usernameValue);

        ResultSet resultSet = statement.executeQuery();
        if(!resultSet.next()){
            return  null;
        }
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String salt = resultSet.getString("salt");
        String saltedPassword = resultSet.getString("salted_password");
        String emri = resultSet.getString("emri");
        String mbiemri = resultSet.getString("mbiemri");
        Date dateLindja = resultSet.getDate("data_e_lindjes");
        int vendlindjaId = resultSet.getInt("vendlindja_id");
        int komunaId = resultSet.getInt("komuna_id");
        int prindiId = resultSet.getInt("prindi_id");
        int klasaId = resultSet.getInt("klasa_id");
        return new Nxenesi(
                id,
                username,
                salt,
                saltedPassword,
                emri,
                mbiemri,
                dateLindja,
                vendlindjaId,
                komunaId,
                prindiId,
                klasaId);
    }

}
