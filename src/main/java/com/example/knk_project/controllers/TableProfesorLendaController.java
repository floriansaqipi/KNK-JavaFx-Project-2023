package com.example.knk_project.controllers;



import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.ProfesoriNotaTableView;
import com.example.knk_project.services.ProfesoriLendaService;
import com.example.knk_project.services.interfaces.ProfesoriLendaServiceInterface;
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

public class TableProfesorLendaController implements Initializable {
    private boolean clickedOnce = false;

    private TableProfesorLendaController tableProfesorLendaController = this;

    private ProfesoriLendaServiceInterface profesoriLendaService = new ProfesoriLendaService();

    @FXML
    private TableColumn<AdminProfesorLendaTableView, AdminProfesorLendaTableView> deleteCol;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, AdminProfesorLendaTableView> editCol;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, String> lendaEmriCol;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, Integer> lendaIdCol;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, String> profesorEmriCol;

    @FXML
    private TableView<AdminProfesorLendaTableView> profesorKlasaTableView;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, Integer> profesoriIdCol;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, String> profesoriMbiemriCol;

    @FXML
    private TableColumn<AdminProfesorLendaTableView, String> usernameCol;

    private ObservableList<AdminProfesorLendaTableView> profesorLendaDataList = FXCollections.observableArrayList();


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
        this.profesorKlasaTableView.setItems(profesorLendaDataList);
        this.addDeleteButtonToTable();
        this.addEditButtonToTable();
    }

    private void insertData() throws SQLException {
        this.profesoriLendaService.addDataToProfesorLendaDataList(profesorLendaDataList);
    }

    private void addDeleteButtonToTable(){

        deleteCol.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Delete");

            {
                button.setOnAction(event -> {
                    // Handle button click event here
                    // You can access the row item using getTableView().getItems().get(getIndex())
                    AdminProfesorLendaTableView profesorLendaTableView = getTableView().getItems().get(getIndex());
                    ProfesoriLenda profesoriLenda =
                            new ProfesoriLenda(profesorLendaTableView.getProfesori().getId(),
                                    profesorLendaTableView.getLenda().getId()
                                    );

                    try{
                        profesoriLendaService.delete(profesoriLenda);
                        initData();
                    }catch (SQLException exception) {
                        exception.printStackTrace();
                        messageLabel.setText("Something went wrong with the database");
                    }
                });
            }

            @Override
            protected void updateItem(AdminProfesorLendaTableView adminProfesorLendaTableView, boolean empty) {
                super.updateItem(adminProfesorLendaTableView, empty);
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
                    AdminProfesorLendaTableView adminProfesorLendaTableView = getTableView().getItems().get(getIndex());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                            "edit-profesor-lenda-view.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                        EditProfesorLendaController editProfesorLendaController = loader.getController();
                        editProfesorLendaController.setAdminProfesorLendaTableView(adminProfesorLendaTableView);
                        editProfesorLendaController.setTableProfesorLendaController(tableProfesorLendaController);

                        editProfesorLendaController.initData();
                        Scene scene = new Scene(anchorPane);
                        Stage editStage = new Stage();
                        editStage.setOnCloseRequest(eventClose -> {
                            tableProfesorLendaController.initData();
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
            protected void updateItem(AdminProfesorLendaTableView adminProfesorLendaTableView, boolean empty) {
                super.updateItem(adminProfesorLendaTableView, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }

    private void setTableData(){
        profesoriIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getProfesori().getId()).asObject());
        profesorEmriCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfesori().getEmri()));
        profesoriMbiemriCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfesori().getMbiemri()));
        usernameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfesori().getUsername()));
        lendaIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getLenda().getId()).asObject());
        lendaEmriCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLenda().getEmri()));

    }

}

