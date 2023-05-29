package com.example.knk_project.controllers;


import com.example.knk_project.models.*;
import com.example.knk_project.services.NotaService;
import com.example.knk_project.services.interfaces.NotaServiceInterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Date;
import java.util.ResourceBundle;


public class TableNotaControllerNew implements Initializable {
    private boolean clickedOnce = false;


    private Profesori profesori;

    TableNotaControllerNew tableNotaControllerNew = this;

    private NotaServiceInterface notaService = new NotaService();

    @FXML
    private Label messageLabel;

    @FXML
    private TableView<ProfesoriNotaTableView> notaTableView;

    @FXML
    private TableColumn<ProfesoriNotaTableView, Integer> notaIdCol;
    @FXML
    private TableColumn<ProfesoriNotaTableView, String> emriLendesCol;

    @FXML
    private TableColumn<ProfesoriNotaTableView, Integer> gjysmevjetoriCol;


    @FXML
    private TableColumn<ProfesoriNotaTableView, Integer> nxIdCol;

    @FXML
    private TableColumn<ProfesoriNotaTableView, String> nxUsernameCol;

    @FXML
    private TableColumn<ProfesoriNotaTableView, Integer> rubrikaCol;

    @FXML
    private TableColumn<ProfesoriNotaTableView, Integer> vleraCol;

    @FXML
    private TableColumn<ProfesoriNotaTableView, ProfesoriNotaTableView> deleteCol;


    @FXML
    private TableColumn<ProfesoriNotaTableView, ProfesoriNotaTableView> editCol;

    private ObservableList<ProfesoriNotaTableView> gradesDatalist = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTableData();

    }

    public void initData(){
        try{
            this.clickedOnce = false;
            insertData();

        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
        this.notaTableView.setItems(gradesDatalist);
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
                    Nota nota = getTableView().getItems().get(getIndex()).getNota();
                    try{
                    notaService.deleteNotaByNotaId(nota.getId());
                    initData();
                    }catch (SQLException exception) {
                        exception.printStackTrace();
                        messageLabel.setText("Something went wrong with the database");
                    }
                });
            }

            @Override
            protected void updateItem(ProfesoriNotaTableView profesoriNotaTableView, boolean empty) {
                super.updateItem(profesoriNotaTableView, empty);
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
                    ProfesoriNotaTableView profesoriNotaTableView = getTableView().getItems().get(getIndex());
                    Nota nota = profesoriNotaTableView.getNota();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                            "edit-nota-profesori-view.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                        EditGradeController editGradeController = loader.getController();
                        editGradeController.setProfesori(profesori);
                        editGradeController.setProfesoriNotaTableView(profesoriNotaTableView);
                        editGradeController.setTableNotaControllerNew(tableNotaControllerNew);
                        editGradeController.initData();
                        Scene scene = new Scene(anchorPane);
                        Stage editStage = new Stage();
                        editStage.setOnCloseRequest(eventClose -> {
                            tableNotaControllerNew.initData();
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
            protected void updateItem(ProfesoriNotaTableView profesoriNotaTableView, boolean empty) {
                super.updateItem(profesoriNotaTableView, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }

    private void setTableData(){
        notaIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNota().getId()).asObject());
        vleraCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNota().getVlera()).asObject());
        gjysmevjetoriCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNota().getGjysmevjetori()).asObject());
        rubrikaCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNota().getRubrika()).asObject());
        emriLendesCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLenda().getEmri()));
        nxUsernameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNxenesi().getUsername()));
        nxIdCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNota().getNxenesiId()).asObject());
    }

    private void insertData() throws SQLException {
        this.notaService.addDataToGradesDataList(this.gradesDatalist,this.profesori.getId());
    }

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }
}


