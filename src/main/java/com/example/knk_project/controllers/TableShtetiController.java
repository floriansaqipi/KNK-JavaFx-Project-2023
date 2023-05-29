package com.example.knk_project.controllers;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.Shteti;
import com.example.knk_project.repositories.interfaces.ShtetiRepositoryInterface;
import com.example.knk_project.services.KomunaService;
import com.example.knk_project.services.ShtetiService;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableShtetiController implements Initializable {

    private boolean clickedOnce = false;
    private TableShtetiController tableShtetiController =  this;

    @FXML
    private TableColumn<Shteti, Shteti> deleteColumn;

    @FXML
    private TableColumn<Shteti, Shteti> editColumn;

    @FXML
    private TableColumn<Shteti, String> emriShtetitColumn;

    @FXML
    private TableView<Shteti> shtetiTableView;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<Shteti, Integer> shtetiIDColumn;


    private ObservableList<Shteti> shtetiDatalist;


    private ShtetiServiceInterface shtetiService = new ShtetiService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeShtetiTableView();

    }

    public void initData(){
        try{
            this.clickedOnce = false;
            insertData();

        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
        this.shtetiTableView.setItems(shtetiDatalist);
        this.addDeleteButtonToTable();
        this.addEditButtonToTable();
    }

    private void addDeleteButtonToTable(){

        deleteColumn.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Delete");

            {
                button.setOnAction(event -> {
                    // Handle button click event here
                    // You can access the row item using getTableView().getItems().get(getIndex())
                    Shteti shteti = getTableView().getItems().get(getIndex());
                    try{
                        shtetiService.deleteShtetiByShtetiId(shteti.getId());
                        initData();
                    }catch (SQLException exception) {
                        exception.printStackTrace();
                        messageLabel.setText("Something went wrong with the database");
                    }
                });
            }

            @Override
            protected void updateItem(Shteti shteti, boolean empty) {
                super.updateItem(shteti, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });
    }

    private void addEditButtonToTable(){
        editColumn.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Edit");

            {
                button.setOnAction(event -> {
                    // Handle button click event here
                    // You can access the row item using getTableView().getItems().get(getIndex())
                    if (clickedOnce){
                        return;
                    }
                    clickedOnce = true;
                    Shteti shteti = getTableView().getItems().get(getIndex());
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                            "edit-shteti-view.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                        EditShtetiController editShtetiController = loader.getController();
                        editShtetiController.setShteti(shteti);
                        editShtetiController.setTableShtetiController(tableShtetiController);
                        editShtetiController.initData();
                        Scene scene = new Scene(anchorPane);
                        Stage editStage = new Stage();
                        editStage.setOnCloseRequest(eventClose -> {
                            tableShtetiController.initData();
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
            protected void updateItem(Shteti shteti, boolean empty) {
                super.updateItem(shteti, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }

    private void insertData() throws SQLException {
        this.shtetiDatalist = FXCollections.observableArrayList(this.shtetiService.getAllShtetet());
    }

    void initalizeShtetiTableView() {
        shtetiIDColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getId()).asObject());
        emriShtetitColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getEmri()));
    }
}
