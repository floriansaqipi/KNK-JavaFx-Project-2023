package com.example.knk_project.controllers;

import com.example.knk_project.models.User;
import com.example.knk_project.services.*;
import com.example.knk_project.services.interfaces.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    private MainController mainController;

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
    private TextField searchTextField;

    @FXML
    private ComboBox<String> roleFilterComboBox;


    @FXML
    public void goBackDashboard(ActionEvent event){
        BorderPane adminPagePane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/adminpage-view.fxml"));
            adminPagePane = fxmlLoader.load();
            AdminPageController adminPageController = fxmlLoader.getController();
            adminPageController.setMainController(mainController);
            adminPageController.initData();
            mainController.setMainPane(adminPagePane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private AdminDashboardServiceInterface adminDashboardService = new AdminDashboardService();
    private NotaServiceInterface notaService = new NotaService();
    private NxenesiServiceInterface nxenesiService = new NxenesiService();
    private ProfesoriServiceInterface profesoriService = new ProfesoriService();
    private KlasaServiceInterface klasaService =  new KlasaService();
    ObservableList<User> listOfUsers;
    private String[] rolesOptions = {"nxenes", "profesor","asnjera"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.numriNotaveLabel.setText(this.notaService.getNumberOfGrades() + " ");
            this.numriNxenesveLabel.setText(this.nxenesiService.getNumberOfNxenesve() + " ");
            this.numriProfesoreveLabel.setText(this.profesoriService.getNumberOfProfesoreve() + " ");
            this.numriKlasaveLabel.setText(this.klasaService.getNumberOfKlaseve() + " ");
            listOfUsers = FXCollections.observableArrayList(this.adminDashboardService.getAllUsers());
            this.initializeRoleFilterComboBox();
            this.initializeUsersTableView();
            initializeSearchTextField();
            this.initializeAdminPieChart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void initializeSearchTextField() {
        FilteredList<User> filteredData =  new FilteredList<>(listOfUsers, b -> true);
        searchTextField.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(user -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                     return true;
                }
                String searchKeyWord =  newValue.toLowerCase();

                if(user.getEmri().toLowerCase().contains(searchKeyWord)){
                    return true;
                }
                else if(user.getMbiemri().toLowerCase().contains(searchKeyWord)){
                    return true;
                }
                else if(user.getUsername().toLowerCase().contains(searchKeyWord)){
                    return true;
                } else if (user.getRoli().contains(searchKeyWord)) {
                    return true;
                } else if (Integer.toString(user.getId()).contains(searchKeyWord)) {
                    return true;
                } else {
                    return false;
                }
            });

                });

        SortedList<User>  sortedData =  new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(usersTableView.comparatorProperty());
        usersTableView.setItems(sortedData);

    }

    private void initializeUsersTableView() throws SQLException {
        userIdTableColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getId()).asObject());
        usernameTableColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getUsername()));
        emriTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getEmri()));
        mbiemriTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getMbiemri()));
        roliTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRoli()));

        usersTableView.setItems(listOfUsers);
    }

    private void initializeAdminPieChart() throws SQLException {
         ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                 new PieChart.Data("Nxenesit", this.nxenesiService.getNumberOfNxenesve()),
                 new PieChart.Data("Profesoret", this.profesoriService.getNumberOfProfesoreve())
         );
         adminPieChart.setData(pieChartData);
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void initializeRoleFilterComboBox() {
       this.roleFilterComboBox.getItems().addAll(this.rolesOptions);
    }

    @FXML
    void filterTableByRole(ActionEvent event) throws SQLException {
        this.searchTextField.setText("");
        String role = this.roleFilterComboBox.getValue();
        if(Objects.equals(role, "nxenes")) {
            listOfUsers = FXCollections.observableArrayList(this.adminDashboardService.getAllUsersNxenes());
        }
        else if (Objects.equals(role, "profesor")) {
            listOfUsers = FXCollections.observableList(this.adminDashboardService.getAllUsersProfesor());
        }
        else {
            listOfUsers = FXCollections.observableArrayList(this.adminDashboardService.getAllUsers());
        }
        usersTableView.setItems(listOfUsers);
        initializeSearchTextField();

    }
}
