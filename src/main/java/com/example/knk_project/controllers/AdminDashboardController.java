package com.example.knk_project.controllers;

import com.example.knk_project.models.User;
import com.example.knk_project.services.AdminDashboardService;
import com.example.knk_project.services.interfaces.AdminDashboardServiceInterface;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.numriNotaveLabel.setText(this.adminDashboardService.getNumberOfGrades() + " ");
            this.numriNxenesveLabel.setText(this.adminDashboardService.getNumberOfNxenesve() + " ");
            this.numriProfesoreveLabel.setText(this.adminDashboardService.getNumberOfProfesoreve() + " ");
            this.numriKlasaveLabel.setText(this.adminDashboardService.getNumberOfKlaseve() + " ");
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
                 new PieChart.Data("Nxenesit", this.adminDashboardService.getNumberOfNxenesve()),
                 new PieChart.Data("Profesoret", this.adminDashboardService.getNumberOfProfesoreve())
         );
         adminPieChart.setData(pieChartData);
    }
}
