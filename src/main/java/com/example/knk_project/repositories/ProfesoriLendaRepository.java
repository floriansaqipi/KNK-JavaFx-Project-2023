package com.example.knk_project.repositories;

import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriLendaDto;
import com.example.knk_project.repositories.interfaces.ProfesoriLendaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesoriLendaRepository implements ProfesoriLendaRepositoryInterface {
    @Override
    public void insert(ProfesoriLenda profesoriLenda) throws SQLException {
        String sql = "INSERT INTO profesoret_lendet(profesori_id, lenda_id) VALUES (?,?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriLenda.getProfesoriId());
        preparedStatement.setInt(2,profesoriLenda.getLendaId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(ProfesoriLenda profesoriLenda) throws SQLException {
        String sql = "DELETE FROM profesoret_lendet pl WHERE pl.profesori_id = ? AND pl.lenda_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriLenda.getProfesoriId());
        preparedStatement.setInt(2,profesoriLenda.getLendaId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<ProfesoriLenda> getAllProfesoriLendet() throws SQLException {
        String sql = "SELECT * FROM profesoret_lendet; ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<ProfesoriLenda> profesoriLendetList = new ArrayList<>();
        while (resultSet.next()){
            profesoriLendetList.add(
                    new ProfesoriLenda(
                            resultSet.getInt(1),
                            resultSet.getInt(2)
                            )
            );
        }
        return profesoriLendetList;
    }

    @Override
    public void update(UpdateProfesoriLendaDto updateProfesoriLendaDto) throws SQLException {
        String sql = "UPDATE profesoret_lendet pl SET profesori_id = ?, lenda_id = ? " +
                "WHERE profesori_id = ? AND lenda_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updateProfesoriLendaDto.getNewProfesoriId());
        preparedStatement.setInt(2, updateProfesoriLendaDto.getNewLendaId());
        preparedStatement.setInt(3, updateProfesoriLendaDto.getProfesoriId());
        preparedStatement.setInt(4, updateProfesoriLendaDto.getLendaId());
        preparedStatement.executeUpdate();
    }

    @Override
    public ProfesoriLenda getProfesoriLendaById(ProfesoriLenda profesoriLenda) throws SQLException {
        String sql = "SELECT * FROM profesoret_lendet pl WHERE pl.profesori_id = ? AND pl.lenda_id = ?; ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriLenda.getProfesoriId());
        preparedStatement.setInt(2,profesoriLenda.getLendaId());

        ResultSet resultSet = preparedStatement.executeQuery();

        ProfesoriLenda profesoriLendaIns = null;
        if (resultSet.next()){
            profesoriLendaIns =
                    new ProfesoriLenda(
                            resultSet.getInt(1),
                            resultSet.getInt(2)
                    );

        }
        return profesoriLendaIns;
    }

}
