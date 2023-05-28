package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import com.example.knk_project.repositories.interfaces.ProfesoriKlasaRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesoriKlasaRepository implements ProfesoriKlasaRepositoryInterface {
    @Override
    public void insert(ProfesoriKlasa profesoriKlasa) throws SQLException {
        String sql = "INSERT INTO profesoret_klasat(profesori_id, klasa_id) VALUES (?,?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriKlasa.getProfesoriId());
        preparedStatement.setInt(2,profesoriKlasa.getKlasaId());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<ProfesoriKlasa> getAllProfesoriKlasat() throws SQLException {
        String sql = "SELECT * FROM profesoret_klasat; ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<ProfesoriKlasa> profesoriKlasatList = new ArrayList<>();
        while (resultSet.next()){
            profesoriKlasatList.add(
                    new ProfesoriKlasa(
                            resultSet.getInt(1),
                            resultSet.getInt(2)
                    )
            );
        }
        return profesoriKlasatList;
    }

    @Override
    public void delete(ProfesoriKlasa profesoriKlasa) throws SQLException {
        String sql = "DELETE FROM profesoret_klasat kl WHERE kl.profesori_id = ? AND kl.klasa_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,profesoriKlasa.getProfesoriId());
        preparedStatement.setInt(2,profesoriKlasa.getKlasaId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(UpdateProfesoriKlasaDto updateProfesoriKlasaDto) throws SQLException {
        String sql = "UPDATE profesoret_klasat kl SET profesori_id = ?, klasa_id = ? " +
                "WHERE profesori_id = ? AND klasa_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updateProfesoriKlasaDto.getNewProfesoriId());
        preparedStatement.setInt(2, updateProfesoriKlasaDto.getNewKlasaId());
        preparedStatement.setInt(3, updateProfesoriKlasaDto.getProfesoriId());
        preparedStatement.setInt(4, updateProfesoriKlasaDto.getKlasaId());
        preparedStatement.executeUpdate();
    }


}
