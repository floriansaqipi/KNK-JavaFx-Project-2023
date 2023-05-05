package com.example.knk_project.repositories;

import com.example.knk_project.repositories.interfaces.ProfesoriLendaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesoriLendaRepository implements ProfesoriLendaRepositoryInterface {
    @Override
    public void insert(ProfesoriLenda profesoriLenda) throws SQLException {
        String sql = "INSERT INTO profesoret_lenda(profesori_id, lenda_id) VALUES (?,?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriLenda.getProfesoriId());
        preparedStatement.setInt(2,profesoriLenda.getLendaId());

        preparedStatement.executeUpdate();
    }
}
