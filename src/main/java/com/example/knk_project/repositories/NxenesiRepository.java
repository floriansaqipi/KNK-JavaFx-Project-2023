package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
