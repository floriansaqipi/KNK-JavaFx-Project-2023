package com.example.knk_project.controllers;

import com.example.knk_project.models.KomunaShteti;
import com.example.knk_project.models.User;
import com.example.knk_project.models.dto.CreateUpdatedKomunaDto;
import com.example.knk_project.services.*;
import com.example.knk_project.services.interfaces.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableKomunaController implements Initializable {
    @FXML
    private TableView<KomunaShteti> komunaTableView;
    @FXML
    private TableColumn<KomunaShteti, String> deleteColumn;

    @FXML
    private TableColumn<KomunaShteti, String> editColumn;

    @FXML
    private TableColumn<KomunaShteti, String> emriColumn;

    @FXML
    private TableColumn<KomunaShteti, String> emriShtetitColumn;

    @FXML
    private TableColumn<KomunaShteti, Integer> komunaIDColumn;

    @FXML
    private TableColumn<KomunaShteti, Integer> shtetiIDColumn;



    private KomunaServiceInterface komunaService = new KomunaService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.initalizeKomunaShtetiTableView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void initalizeKomunaShtetiTableView() throws SQLException {
        ObservableList<KomunaShteti> listOfUsers = FXCollections.observableArrayList(this.komunaService.getKomunaShtetiTable());
        komunaIDColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getKomunaID()).asObject());
        emriColumn.setCellValueFactory( p -> new SimpleStringProperty(p.getValue().getEmriKomunes()));
        shtetiIDColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getShtetiID()).asObject());
        emriShtetitColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getEmriShtetit()));

        komunaTableView.setItems(listOfUsers);


    }
}
