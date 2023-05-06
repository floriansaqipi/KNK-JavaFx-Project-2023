package com.example.knk_project.repositories;

import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.repositories.interfaces.NotaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotaRepository implements NotaRepositoryInterface {
    @Override
    public void insert(CreateNotaDto createNotaDto) throws SQLException {
        String sql = "INSERT INTO notat(vlera, rubrika, gjysemvjetori, profesori_id, lenda_id, nxenesi_id) " +
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
}
