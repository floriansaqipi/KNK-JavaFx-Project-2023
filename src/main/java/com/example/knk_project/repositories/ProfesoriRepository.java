package com.example.knk_project.repositories;

import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.repositories.interfaces.ProfesoriRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Profesori getProfesoriById(int profesoriId) throws SQLException {
        String sql = "SELECT * FROM profesoret n WHERE n.id = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1 , profesoriId);

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

    @Override
    public List<Profesori> getAllProfesoret() throws SQLException {
        String sql = "SELECT * FROM profesoret;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Profesori> profesoret = new ArrayList<>();

        while (resultSet.next()){
            profesoret.add(
                    new Profesori(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7)
                            )
            );
        }
        return profesoret;

    }

    @Override
    public int getNumberOfProfesoreve() throws SQLException {
        String sql = "SELECT COUNT(*) FROM profesoret;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfProfesoreve = 0;

        while (resultSet.next()){
            numberOfProfesoreve = resultSet.getInt(1);
        }
        return numberOfProfesoreve ;
    }

}
