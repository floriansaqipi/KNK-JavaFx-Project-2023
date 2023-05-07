package com.example.knk_project.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class addClassController implements Initializable {
    @FXML
    private ComboBox addClassComboBox;

    @FXML
    private Label label;

    @FXML
    void select(ActionEvent event) {
        String s=addClassComboBox.getSelectionModel().getSelectedItem().toString();
        label.setText(s);

    }
    public <resourceBundle> void initialize(URL url, resourceBundle rb){
        ObservableList<String>list= FXCollections.observableArrayList("Klasa 10","Klasa 11","Klasa 12");
        addClassComboBox.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
