package com.example.knk_project.repositories;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.ProfesoriKlasa;
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


}
