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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {

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
    @FXML
    private LineChart<String, Number> lineChart;


    public void initialize() {
        // Create a new series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Grades in Subjects");

        // Add data points to the series
        series.getData().add(new XYChart.Data<>("Subject 1", 5));
        series.getData().add(new XYChart.Data<>("Subject 2", 4));
        series.getData().add(new XYChart.Data<>("Subject 3", 3));
        series.getData().add(new XYChart.Data<>("Subject 4", 5));
        series.getData().add(new XYChart.Data<>("Subject 5", 4));

        // Add the series to the line chart
        lineChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}