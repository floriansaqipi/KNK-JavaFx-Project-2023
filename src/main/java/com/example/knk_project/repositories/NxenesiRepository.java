package com.example.knk_project.repositories;

import com.example.knk_project.models.Nota;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.services.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Nxenesi> getAllNxenesitbyProfesoriID(int profesoriID) throws SQLException {
        String sql = "SELECT n.* from profesoret p inner join profesoret_klasat pk on pk.profesori_id = p.id inner join klasa k on k.id = pk.klasa_id inner join nxenesit n on n.klasa_id = k.id where p.id =" + profesoriID + ";";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Nxenesi> nxenesit = new ArrayList<>();

        while (resultSet.next()){
            nxenesit.add(
                    new Nxenesi(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getDate(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getInt(11)

                    )
            );
        }
        return nxenesit;
    }

    @Override

    public List<Nxenesi> getAllNxenesitByKlasaId(int klasaId) throws SQLException {
        String sql = "SELECT * FROM nxenesit n WHERE n.klasa_id = ? ;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, klasaId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Nxenesi> nxenesit = new ArrayList<>();

        while (resultSet.next()){
            nxenesit.add(
                    new Nxenesi(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getDate(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getInt(11)

                    )
            );
        }
        return nxenesit;

    public int getNumberOfNxenesve() throws SQLException {
        String sql = "SELECT COUNT(*) FROM nxenesit;";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        int numberOfNxenseve = 0;

        while (resultSet.next()){
            numberOfNxenseve = resultSet.getInt(1);
        }
        return numberOfNxenseve ;

    }

}
