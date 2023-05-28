package com.example.knk_project.controllers;



import com.example.knk_project.models.AdminProfesorKlasaTableView;
import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.services.ProfesoriKlasaService;
import com.example.knk_project.services.interfaces.ProfesoriKlasaServiceInterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableProfesorKlasaController implements Initializable {
    private boolean clickedOnce = false;

    private ProfesoriKlasaServiceInterface profesoriKlasaService = new ProfesoriKlasaService();

    private TableProfesorKlasaController tableProfesorKlasaController = this;


    @FXML
    private TableColumn<AdminProfesorKlasaTableView, AdminProfesorKlasaTableView> deleteCol;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, AdminProfesorKlasaTableView> editCol;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, Integer> klasaCol;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, Integer> klasaIdCol;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, Integer> paraleljaCol;

    @FXML
    private TableView<AdminProfesorKlasaTableView> profesorKlasaTableView;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, Integer> profesoriIdCol;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, String> usernameCol;

    @FXML
    private TableColumn<AdminProfesorKlasaTableView, String> vitiCol;

    private ObservableList<AdminProfesorKlasaTableView> profesorKlasaDataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setTableData();
    }

    public void initData(){
        try{
            this.clickedOnce = false;
            insertData();

        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
        this.profesorKlasaTableView.setItems(profesorKlasaDataList);
        this.addDeleteButtonToTable();
        this.addEditButtonToTable();
    }

    private void addDeleteButtonToTable(){

        deleteCol.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Delete");

            {
                button.setOnAction(event -> {
                    // Handle button click event here
                    // You can access the row item using getTableView().getItems().get(getIndex())
                    AdminProfesorKlasaTableView profesorKlasaTableView = getTableView().getItems().get(getIndex());
                    ProfesoriKlasa profesoriKlasa =
                            new ProfesoriKlasa(profesorKlasaTableView.getProfesori().getId(),
                                    profesorKlasaTableView.getKlasa().getId()
                            );

                    try{
                        profesoriKlasaService.delete(profesoriKlasa);
                        initData();
                    }catch (SQLException exception) {
                        exception.printStackTrace();
                        messageLabel.setText("Something went wrong with the database");
                    }
                });
            }

            @Override
            protected void updateItem(AdminProfesorKlasaTableView adminProfesorKlasaTableView, boolean empty) {
                super.updateItem(adminProfesorKlasaTableView, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });
    }
    private void addEditButtonToTable(){
        editCol.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Edit");

            {
                button.setOnAction(event -> {
                    // Handle button click event here
                    // You can access the row item using getTableView().getItems().get(getIndex())
                    if (clickedOnce){
                        return;
                    }
                    clickedOnce = true;
                    AdminProfesorKlasaTableView adminProfesorKlasaTableView = getTableView().getItems().get(getIndex());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                            "edit-profesor-klasa-view.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                        EditProfesoriKlasaController editProfesoriKlasaController = loader.getController();
                        editProfesoriKlasaController.setAdminProfesorKlasaTableView(adminProfesorKlasaTableView);
                        editProfesoriKlasaController.setTableProfesorKlasaController(tableProfesorKlasaController);

                        editProfesoriKlasaController.initData();
                        Scene scene = new Scene(anchorPane);
                        Stage editStage = new Stage();
                        editStage.setOnCloseRequest(eventClose -> {
                            tableProfesorKlasaController.initData();
                            editStage.close();
                        });
                        editStage.setScene(scene);
                        editStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        messageLabel.setText("Something went wrong with the controller");

                    }
                });
            }

            @Override
            protected void updateItem(AdminProfesorKlasaTableView adminProfesorKlasaTableView, boolean empty) {
                super.updateItem(adminProfesorKlasaTableView, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }



    private void insertData() throws SQLException {
        this.profesoriKlasaService.addDataToProfesorKlasaDataList(profesorKlasaDataList);
    }

    private void setTableData(){
        profesoriIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getProfesori().getId()).asObject());
        usernameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfesori().getUsername()));
        klasaIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getKlasa().getId()).asObject());
        klasaIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getKlasa().getId()).asObject());
        klasaCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getKlasa().getKlasa()).asObject());
        paraleljaCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getKlasa().getParalelja()).asObject());
        vitiCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKlasa().getViti()));
    }
}
