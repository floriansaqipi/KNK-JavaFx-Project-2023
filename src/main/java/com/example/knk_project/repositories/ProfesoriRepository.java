package com.example.knk_project.repositories;

import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesoriRepository implements ProfesoriRepositoryInterface {
    @Override
    public void insert(CreateProfesoriDto createProfesoriDto) throws SQLException {
        String sql = "INSERT INTO profesoret (username, salt, salted_password, emri, mbiemri, titulli)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,createProfesoriDto.getUsername());
        statement.setString(2,createProfesoriDto.getSalt());
        statement.setString(3,createProfesoriDto.getSaltedPassword());
        statement.setString(4,createProfesoriDto.getEmri());
        statement.setString(5,createProfesoriDto.getMbiemri());
        statement.setString(6,createProfesoriDto.getTitulli());

        statement.executeUpdate();
    }

    public Profesori getProfesoriByUsername(String usernameValue) throws SQLException {
        String sql = "SELECT * FROM profesoret n WHERE n.username = ?";
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
        String titulli = resultSet.getString("titulli");
        return new Profesori(
                id,
                username,
                salt,
                saltedPassword,
                emri,
                mbiemri,
                titulli
        );
    }

}
