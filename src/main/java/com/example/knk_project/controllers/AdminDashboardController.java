package com.example.knk_project.controllers;

import com.example.knk_project.models.User;
import com.example.knk_project.services.*;
import com.example.knk_project.services.interfaces.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private PieChart adminPieChart;

    @FXML
    private Label numriNotaveLabel;

    @FXML
    private Label numriNxenesveLabel;

    @FXML
    private Label numriProfesoreveLabel;
    @FXML
    private Label numriKlasaveLabel;
    @FXML
    private TableView<User> usersTableView;

    @FXML
    private TableColumn<User, Integer> userIdTableColumn;

    @FXML
    private TableColumn<User, String> usernameTableColumn;
    @FXML
    private TableColumn<User, String> emriTableColumn;

    @FXML
    private TableColumn<User, String> mbiemriTableColumn;
    @FXML
    private TableColumn<User, String> roliTableColumn;


    private AdminDashboardServiceInterface adminDashboardService = new AdminDashboardService();
    private NotaServiceInterface notaService = new NotaService();
    private NxenesiServiceInterface nxenesiService = new NxenesiService();
    private ProfesoriServiceInterface profesoriService = new ProfesoriService();
    private KlasaServiceInterface klasaService =  new KlasaService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.numriNotaveLabel.setText(this.notaService.getNumberOfGrades() + " ");
            this.numriNxenesveLabel.setText(this.nxenesiService.getNumberOfNxenesve() + " ");
            this.numriProfesoreveLabel.setText(this.profesoriService.getNumberOfProfesoreve() + " ");
            this.numriKlasaveLabel.setText(this.klasaService.getNumberOfKlaseve() + " ");
            this.initalizeUsersTableView();
            this.initializeAdminPieChart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void initalizeUsersTableView() throws SQLException {
        ObservableList<User> listOfUsers = FXCollections.observableArrayList(this.adminDashboardService.getAllUsers());
        userIdTableColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getId()).asObject());
        usernameTableColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getUsername()));
        emriTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getEmri()));
        mbiemriTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getMbiemri()));
        roliTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRoli()));

        usersTableView.setItems(listOfUsers);
    }

    public void initializeAdminPieChart() throws SQLException {
         ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                 new PieChart.Data("Nxenesit", this.nxenesiService.getNumberOfNxenesve()),
                 new PieChart.Data("Profesoret", this.profesoriService.getNumberOfProfesoreve())
         );
         adminPieChart.setData(pieChartData);
    }
}
