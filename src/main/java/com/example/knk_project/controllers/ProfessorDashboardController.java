package com.example.knk_project.controllers;

import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.User;
import com.example.knk_project.services.AdminDashboardService;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.interfaces.AdminDashboardServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfessorDashboardController implements Initializable {
    private  MainController mainController;

    private Profesori profesori;

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


    @FXML
    public void goBackDashboard(ActionEvent event){
        BorderPane profesorPagePane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/profesor-page-view.fxml"));
            profesorPagePane = fxmlLoader.load();
            ProfesorPageController profesorPageController = fxmlLoader.getController();
            profesorPageController.setMainController(mainController);
            profesorPageController.setProfesori(profesori);
            profesorPageController.initData();
            mainController.setMainPane(profesorPagePane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void setProfesori(Profesori profesori){
        this.profesori = profesori;
    }

    public void printProfesori(){
        System.out.println(this.profesori);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

