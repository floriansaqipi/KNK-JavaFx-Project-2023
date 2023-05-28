package com.example.knk_project.controllers;

import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.KomunaShtetiTableView;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.ProfesoriNotaTableView;
import com.example.knk_project.services.*;
import com.example.knk_project.services.interfaces.*;
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

public class TableKomunaController implements Initializable {
    private boolean clickedOnce = false;
    private TableKomunaController tableKomunaController =  this;
    @FXML
    private TableView<KomunaShtetiTableView> komunaTableView;
    @FXML
    private TableColumn<KomunaShtetiTableView, KomunaShtetiTableView> deleteColumn;

    @FXML
    private TableColumn<KomunaShtetiTableView, KomunaShtetiTableView> editColumn;

    @FXML
    private TableColumn<KomunaShtetiTableView, String> emriColumn;

    @FXML
    private TableColumn<KomunaShtetiTableView, String> emriShtetitColumn;

    @FXML
    private TableColumn<KomunaShtetiTableView, Integer> komunaIDColumn;

    @FXML
    private TableColumn<KomunaShtetiTableView, Integer> shtetiIDColumn;
    @FXML
    private Label messageLabel;

    private ObservableList<KomunaShtetiTableView> komunaDatalist;



    private KomunaServiceInterface komunaService = new KomunaService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeKomunaShtetiTableView();

    }

    public void initData(){
        try{
            this.clickedOnce = false;
            insertData();

        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
        this.komunaTableView.setItems(komunaDatalist);
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
                    Komuna komuna = getTableView().getItems().get(getIndex()).getKomuna();
                    try{
                        komunaService.deleteKomunaByKomunaId(komuna.getId());
                        initData();
                    }catch (SQLException exception) {
                        exception.printStackTrace();
                        messageLabel.setText("Something went wrong with the database");
                    }
                });
            }

            @Override
            protected void updateItem(KomunaShtetiTableView komunaShtetiTableView, boolean empty) {
                super.updateItem(komunaShtetiTableView, empty);
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
                    KomunaShtetiTableView komunaShtetiTableView = getTableView().getItems().get(getIndex());
                    Komuna komuna = komunaShtetiTableView.getKomuna();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                            "edit-komuna-view.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                        EditKomunaController editKomunaController = loader.getController();
                        editKomunaController.setKomuna(komuna);
                        editKomunaController.setKomunaShtetiTableView(komunaShtetiTableView);
                        editKomunaController.setTableNotaControllerNew(tableKomunaController);
                        editKomunaController.initData();
                        Scene scene = new Scene(anchorPane);
                        Stage editStage = new Stage();
                        editStage.setOnCloseRequest(eventClose -> {
                            tableKomunaController.initData();
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
            protected void updateItem(KomunaShtetiTableView komunaShtetiTableView, boolean empty) {
                super.updateItem(komunaShtetiTableView, empty);
                if (!empty) {
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }

    private void insertData() throws SQLException {
        this.komunaDatalist = FXCollections.observableArrayList(this.komunaService.getKomunaShtetiTable());
    }

    void initalizeKomunaShtetiTableView() {
        komunaIDColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getKomuna().getId()).asObject());
        emriColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getKomuna().getEmri()));
        shtetiIDColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getShteti().getId()).asObject());
        emriShtetitColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getShteti().getEmri()));
    }
}
